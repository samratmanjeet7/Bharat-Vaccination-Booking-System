package com.example.BharatVaccinationBookingCenter.Controller;

import com.example.BharatVaccinationBookingCenter.Service.PersonService;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.AddPersonRequestDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.AddPersonResponseDto;
import com.example.BharatVaccinationBookingCenter.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody AddPersonRequestDto addPersonRequestDto)
    {

        try
        {
            AddPersonResponseDto personResponseDto = personService.addPerson(addPersonRequestDto);
            return  new ResponseEntity(personResponseDto, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity("Email already Exists",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_email")
    public ResponseEntity updateEmail(@RequestParam("oldEmail") String oldEmail,@RequestParam("newEmail") String newEmail)
    {
        try {
            String personResponse=personService.updateEmail(oldEmail,newEmail);
            return new ResponseEntity(personResponse,HttpStatus.ACCEPTED);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //get all males greater than a certain age;
    @GetMapping("/get_all_males_greater_than")
    public ResponseEntity getAllMalesGreaterThan(@RequestParam("age") int age)
    {
        try{
            List<AddPersonResponseDto> persons=personService.getAllMalesGreaterThan(age);
            return new ResponseEntity(persons,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //get all females who have taken only dose 1 not dose 2;
    @GetMapping("/get_all_females_taken_only_dose1")
    public ResponseEntity getAllFemalesTakenOnlyDose1()
    {
        try {
            List<AddPersonResponseDto> femalePersons=personService.getAllFemalesTakenOnlyDose1();
            return new ResponseEntity(femalePersons,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //get all people who are fully vaccinated;
    @GetMapping("/get_all_people_who_are_fully_vaccinated")
    public ResponseEntity getAllPeopleWhoAreFullyVaccinated()
    {
        try{
            List<AddPersonResponseDto> addPersonResponseDtos=personService.getAllPeopleWhoAreFullyVaccinated();
            return new ResponseEntity(addPersonResponseDtos,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //get all people who have not taken even a single dose;
    @GetMapping("/get_all_who_have_not_taken_a_single_dose")
    public  ResponseEntity getAllWhoHaveNotTakenASingleDose()
    {
        try {
            List<AddPersonResponseDto> addPersonResponseDtos = personService.getAllWhoHaveNotTakenASingleDose();
            return new ResponseEntity(addPersonResponseDtos,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //get all females whose age is greater than a particular age and who have taken only dose 1;
    @GetMapping("/get_females_whose_age_is_greater_than_and_taken_dose1")
    public ResponseEntity getFemalesWhoseAgeIsGreaterThanAndTakenDose1(@RequestParam("age") int age)
    {
        try {
            List<AddPersonResponseDto> addPersonResponseDtos=personService.getFemalesWhoseAgeIsGreaterThanAndTakenDose1(age);
            return new ResponseEntity(addPersonResponseDtos,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //get all males whose age is greater than a particular age and who have taken both doses;
    @GetMapping("/get_males_whose_age_is_greater_than_and_taken_both_doses")
    public ResponseEntity getMalesWhoseAgeIsGreaterThanAndTakenBothDoses(@RequestParam("age") int age)
    {
        try {
            List<AddPersonResponseDto> addPersonResponseDtos=personService.getMalesWhoseAgeIsGreaterThanAndTakenBothDoses(age);
            return new ResponseEntity(addPersonResponseDtos,HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
