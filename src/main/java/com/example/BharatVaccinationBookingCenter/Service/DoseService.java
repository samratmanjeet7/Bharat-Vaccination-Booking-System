package com.example.BharatVaccinationBookingCenter.Service;

import com.example.BharatVaccinationBookingCenter.Enum.DoseType;
import com.example.BharatVaccinationBookingCenter.Exception.DoseAlreadyTakenException;
import com.example.BharatVaccinationBookingCenter.Exception.PersonNotFoundException;
import com.example.BharatVaccinationBookingCenter.Repository.DoseRepository;
import com.example.BharatVaccinationBookingCenter.Repository.PersonRepository;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.BookDose1RequestDto;
import com.example.BharatVaccinationBookingCenter.model.Dose;
import com.example.BharatVaccinationBookingCenter.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    PersonRepository personRepository;

//    public Dose getDose1(int personId, DoseType doseType){
//
//        Optional<Person> optionalPerson=personRepository.findById(personId);
//
//        //Check if person is present or not
//        if (!optionalPerson.isPresent())
//        {
//            throw new PersonNotFoundException("Invalid PersonId");
//        }
//        Person person=optionalPerson.get();
//
//        //Check if dose 1 already taken
//        if(person.isDose1Taken())
//        {
//            throw new DoseAlreadyTakenException("Dose 1 Already taken");
//        }
//
//        //Create a dose object;
//        Dose dose=new Dose();
//        dose.setDoseId(String.valueOf(UUID.randomUUID()));
//        dose.setDoseType(doseType);
//        dose.setPerson(person);
//
//        person.setDose1Taken(true);
//        person.getDosesTaken().add(dose);
//        Person savedPerson=personRepository.save(person);
//
//        //return savedPerson.getDosesTaken().get(0); As showing infinite recursive calls as child calls parent and parent calls child repetitively
//        return dose;//not correct
//    }

    public Dose getDose1(BookDose1RequestDto bookDose1RequestDto) {

        Optional<Person> optionalPerson=personRepository.findById(bookDose1RequestDto.getPersonId());

        //Check if person is present or not
        if (!optionalPerson.isPresent())
        {
            throw new PersonNotFoundException("Invalid PersonId");
        }
        Person person=optionalPerson.get();

        //Check if dose 1 already taken
        if(person.isDose1Taken())
        {
            throw new DoseAlreadyTakenException("Dose 1 Already taken");
        }

        //Create a dose object from Request Dto;
        Dose dose=new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(bookDose1RequestDto.getDoseType());
        dose.setPerson(person);

        person.setDose1Taken(true);
        person.getDosesTaken().add(dose);
        Person savedPerson=personRepository.save(person);

        return savedPerson.getDosesTaken().get(0); //As showing infinite recursive calls as child calls parent and parent calls child repetitively
        //return dose;//not correct

    }
}
