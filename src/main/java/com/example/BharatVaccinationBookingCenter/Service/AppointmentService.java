package com.example.BharatVaccinationBookingCenter.Service;

import com.example.BharatVaccinationBookingCenter.Exception.DoctorBotFoundException;
import com.example.BharatVaccinationBookingCenter.Exception.PersonNotFoundException;
import com.example.BharatVaccinationBookingCenter.Repository.AppointmentRepository;
import com.example.BharatVaccinationBookingCenter.Repository.DoctorRepository;
import com.example.BharatVaccinationBookingCenter.Repository.PersonRepository;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.BookAppointmentRequestDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.BookAppointmentResponseDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.CenterResponseDto;
import com.example.BharatVaccinationBookingCenter.model.Appointment;
import com.example.BharatVaccinationBookingCenter.model.Doctor;
import com.example.BharatVaccinationBookingCenter.model.Person;
import com.example.BharatVaccinationBookingCenter.model.VaccinationCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookAppointmentResponseDto bookAppointment(BookAppointmentRequestDto bookAppointmentRequestDto) {

        //check for both person and doctor whether exists or not
        Optional<Person> optionalPerson=personRepository.findById(bookAppointmentRequestDto.getPersonId());
        if(optionalPerson.isEmpty())
        {
            throw new PersonNotFoundException("Invalid Person Id.");
        }
        Optional<Doctor> optionalDoctor=doctorRepository.findById(bookAppointmentRequestDto.getDoctorId());
        if (optionalDoctor.isEmpty())
        {
            throw new DoctorBotFoundException("Invalid Doctor Id.");
        }
        Person person=optionalPerson.get();
        Doctor doctor=optionalDoctor.get();

        //Create an Appointment Object
        Appointment appointment=new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);

        Appointment savedAppointment=appointmentRepository.save(appointment);

        doctor.getAppointments().add(savedAppointment);
        person.getAppointments().add(savedAppointment);

        Doctor savedDoctor=doctorRepository.save(doctor);
        Person savedPerson=personRepository.save(person);

        VaccinationCenter vaccinationCenter=savedDoctor.getCenter();

        //Send an Email
        String text="Congrats!! "+savedPerson.getName()+" Your Appointment has been booked with Doctor "+savedDoctor.getName()
                +" . Your Vaccination Center name is "+vaccinationCenter.getCenterName()+".Please reach on this address "+vaccinationCenter.getAddress()+
                " at this time "+savedAppointment.getAppointmentDate()+".Thank You!!!";
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("ananyakaushal53@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmail());
        simpleMailMessage.setSubject("Congrats!! Appointment Done!");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

        //VaccinationCenter vaccinationCenter=savedDoctor.getCenter();
        CenterResponseDto centerResponseDto=new CenterResponseDto();
        centerResponseDto.setCenterName(vaccinationCenter.getCenterName());
        centerResponseDto.setCenterType(vaccinationCenter.getCenterType());
        centerResponseDto.setAddress(vaccinationCenter.getAddress());

        //Prepare an AppointmentResponseDto
        BookAppointmentResponseDto bookAppointmentResponseDto=new BookAppointmentResponseDto();
        bookAppointmentResponseDto.setDoctorName(savedDoctor.getName());
        bookAppointmentResponseDto.setPersonName(savedPerson.getName());
        bookAppointmentResponseDto.setAppointmentId(savedAppointment.getAppointmentId());
        bookAppointmentResponseDto.setAppointmentDate(savedAppointment.getAppointmentDate());
        bookAppointmentResponseDto.setCenterResponseDto(centerResponseDto);

        return bookAppointmentResponseDto;
    }
}
