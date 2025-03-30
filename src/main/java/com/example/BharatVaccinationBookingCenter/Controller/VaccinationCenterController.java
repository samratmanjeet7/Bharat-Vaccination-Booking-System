package com.example.BharatVaccinationBookingCenter.Controller;

import com.example.BharatVaccinationBookingCenter.Enum.CenterType;
import com.example.BharatVaccinationBookingCenter.Service.VaccinationCenterService;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.CenterRequestDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.CenterResponseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService centerService;

    @PostMapping("/add_center")
    public CenterResponseDto addCenter(@RequestBody CenterRequestDto centerRequestDto)
    {
        CenterResponseDto centerResponseDto=centerService.addCenter(centerRequestDto);
        return centerResponseDto;
    }

    //get all the doctors at (center's of certain type) a certain CenterType;
    //give centerType


    //get the center with the highest no. of doctors;
    //Max keyword

    //get the center with the highest no of doctors among a particular CenterType;
    //And of both above queries
}
