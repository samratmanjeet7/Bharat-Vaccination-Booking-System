package com.example.BharatVaccinationBookingCenter.Service;

import com.example.BharatVaccinationBookingCenter.Exception.CenterNotFoundException;
import com.example.BharatVaccinationBookingCenter.Repository.DoctorRepository;
import com.example.BharatVaccinationBookingCenter.Repository.VaccinationCenterRepository;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.DoctorRequestDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.CenterResponseDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.DoctorResponseDto;
import com.example.BharatVaccinationBookingCenter.model.Doctor;
import com.example.BharatVaccinationBookingCenter.model.VaccinationCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {

        //Check whether Center Exist or not
        Optional<VaccinationCenter> vaccinationCenterOptional=vaccinationCenterRepository.findById(doctorRequestDto.getCenterId());
        if(vaccinationCenterOptional.isEmpty())
        {
            throw new CenterNotFoundException("Sorry! Wrong Center Id");
        }

        VaccinationCenter center=vaccinationCenterOptional.get();

        //Create Doctor Entity
        Doctor doctor=new Doctor();
        doctor.setName(doctorRequestDto.getName());
        doctor.setAge(doctorRequestDto.getAge());
        doctor.setEmail(doctorRequestDto.getEmail());
        doctor.setGender(doctorRequestDto.getGender());
        doctor.setCenter(center);

        //Add in Center's Doctor List
        center.getDoctors().add(doctor);

        VaccinationCenter savedCenter=vaccinationCenterRepository.save(center);

        //Doctor Entity -> ResponseDto
        List<Doctor> doctors=savedCenter.getDoctors();

        //Prepare CenterResponseDto
        CenterResponseDto centerResponseDto=new CenterResponseDto();
        centerResponseDto.setCenterName(savedCenter.getCenterName());
        centerResponseDto.setCenterType(savedCenter.getCenterType());
        centerResponseDto.setAddress(savedCenter.getAddress());

        Doctor latestSavedDoctor=doctors.get(doctors.size()-1);
        DoctorResponseDto doctorResponseDto=new DoctorResponseDto();
        doctorResponseDto.setName(latestSavedDoctor.getName());
        doctorResponseDto.setMessage("Congrats!! You have been Registered.Center details are follows:-");
        doctorResponseDto.setCenterResponseDto(centerResponseDto);

        return doctorResponseDto;
    }

    public List<String> getByAgeGreaterThan(int age) {
        List<Doctor> doctors=doctorRepository.getByAgeGreaterThan(age);
        List<String> ans=new ArrayList<>();
        for(Doctor d:doctors)
        {
            ans.add(d.getName());
        }
        return ans;
    }
}
