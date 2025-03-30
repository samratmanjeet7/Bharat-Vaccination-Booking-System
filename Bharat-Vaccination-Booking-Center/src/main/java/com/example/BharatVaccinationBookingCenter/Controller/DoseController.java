package com.example.BharatVaccinationBookingCenter.Controller;

import com.example.BharatVaccinationBookingCenter.Enum.DoseType;
import com.example.BharatVaccinationBookingCenter.Exception.PersonNotFoundException;
import com.example.BharatVaccinationBookingCenter.Service.DoseService;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.BookDose1RequestDto;
import com.example.BharatVaccinationBookingCenter.model.Dose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

//    @PostMapping("/get_dose_1")
//    public ResponseEntity getDose1(@RequestParam("id") int personId,@RequestParam("doseType") DoseType doseType) {
//        try
//        {
//            Dose doseTaken=doseService.getDose1(personId,doseType);
//            return new ResponseEntity(doseTaken,HttpStatus.CREATED);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    //using the request DTO
    @PostMapping("/get_dose_1")
    public ResponseEntity getDose1(@RequestBody BookDose1RequestDto bookDose1RequestDto) {
        try
        {
            Dose doseTaken=doseService.getDose1(bookDose1RequestDto);
            return new ResponseEntity(doseTaken,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
