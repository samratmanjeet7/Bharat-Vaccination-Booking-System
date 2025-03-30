package com.example.BharatVaccinationBookingCenter.Controller;

import com.example.BharatVaccinationBookingCenter.Service.AppointmentService;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.BookAppointmentRequestDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.BookAppointmentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestBody BookAppointmentRequestDto bookAppointmentRequestDto)
    {
        try {
            BookAppointmentResponseDto bookAppointmentResponseDto=appointmentService.bookAppointment(bookAppointmentRequestDto);
            return new ResponseEntity(bookAppointmentResponseDto, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //get all the appointments of a particular doctor

    //get all the appointments of a particular person

    //delete an appointment for a person
    
}
