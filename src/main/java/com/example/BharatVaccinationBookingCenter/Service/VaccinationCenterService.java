package com.example.BharatVaccinationBookingCenter.Service;

import com.example.BharatVaccinationBookingCenter.Repository.VaccinationCenterRepository;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.CenterRequestDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.CenterResponseDto;
import com.example.BharatVaccinationBookingCenter.model.VaccinationCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository centerRepository;

    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {

        //request Dto -> entity
        VaccinationCenter vaccinationCenter=new VaccinationCenter();
        vaccinationCenter.setCenterName(centerRequestDto.getCenterName());
        vaccinationCenter.setCenterType(centerRequestDto.getCenterType());
        vaccinationCenter.setAddress(centerRequestDto.getAddress());

        //Save entity to DB
        VaccinationCenter savedCenter = centerRepository.save(vaccinationCenter);

        //entity -> response Dto
        CenterResponseDto centerResponseDto=new CenterResponseDto();
        centerResponseDto.setCenterName(savedCenter.getCenterName());
        centerResponseDto.setCenterType(savedCenter.getCenterType());
        centerResponseDto.setAddress(savedCenter.getAddress());

        //return response entity
        return centerResponseDto;
    }
}
