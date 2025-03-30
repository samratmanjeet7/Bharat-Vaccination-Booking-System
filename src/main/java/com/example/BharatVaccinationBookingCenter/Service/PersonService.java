package com.example.BharatVaccinationBookingCenter.Service;

import com.example.BharatVaccinationBookingCenter.Exception.PersonNotFoundException;
import com.example.BharatVaccinationBookingCenter.Repository.PersonRepository;
import com.example.BharatVaccinationBookingCenter.dto.RequestDto.AddPersonRequestDto;
import com.example.BharatVaccinationBookingCenter.dto.ResponseDto.AddPersonResponseDto;
import com.example.BharatVaccinationBookingCenter.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto)
    {
//        person.setDose1Taken(false);
//        person.setDose2Taken(false);
//        person.setCertificate(null);//by default all these three attributes are also null
//        Person savedPerson=personRepository.save(person);
//        return savedPerson;

        //Convert Request DTO to Entity
        Person person=new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setEmail(addPersonRequestDto.getEmail());
        person.setGender(addPersonRequestDto.getGender());
//        person.setDose1Taken(false);
//        person.setDose2Taken(false);
//        person.setCertificate(null);

        Person savedPerson=personRepository.save(person);

        //Convert saved Entity to Response DTO
        AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
        addPersonResponseDto.setName(savedPerson.getName());
        addPersonResponseDto.setMassege("Congrats! You have been Registered");

        return addPersonResponseDto;
    }

    public String updateEmail(String oldEmail, String newEmail) {

        Person person=personRepository.findByEmail(oldEmail);
        if (person==null)
        {
            throw new PersonNotFoundException("Sorry EmailId does not exists");
        }

        person.setEmail(newEmail);
        personRepository.save(person);

        return "Congrats! Your Email has been updated successfully";
    }

    //get all males greater than a certain age;
    public List<AddPersonResponseDto> getAllMalesGreaterThan(int age) {
        List<Person> persons=personRepository.getAllMalesGreaterThan(age);
        List<AddPersonResponseDto> personResponseDto=new ArrayList<>();

        //Convert Entity -> Response Dto
        for (Person p:persons)
        {
            AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
            addPersonResponseDto.setName(p.getName());
            addPersonResponseDto.setMassege("Age Greater than:-"+age);
            personResponseDto.add(addPersonResponseDto);
        }
        return personResponseDto;
    }

    //get all females who have taken only dose 1 not dose 2;
    public List<AddPersonResponseDto> getAllFemalesTakenOnlyDose1() {
        List<Person> persons=personRepository.getAllFemalesTakenOnlyDose1();
        List<AddPersonResponseDto> personResponseDtos=new ArrayList<>();

        //Convert Entity -> Response Dto
        for (Person p:persons)
        {
            AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
            addPersonResponseDto.setName(p.getName());
            addPersonResponseDto.setMassege("Female taken only Dose 1.");
            personResponseDtos.add(addPersonResponseDto);
        }
        return personResponseDtos;
    }

    //get all people who are fully vaccinated;
    public List<AddPersonResponseDto> getAllPeopleWhoAreFullyVaccinated() {
        List<Person> persons=personRepository.getAllPeopleWhoAreFullyVaccinated();
        List<AddPersonResponseDto> addPersonResponseDtos=new ArrayList<>();

        //Convert Entity -> Response Dto
        for (Person p:persons)
        {
            AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
            addPersonResponseDto.setName(p.getName());
            addPersonResponseDto.setMassege("Fully Vaccinated Person.");
            addPersonResponseDtos.add(addPersonResponseDto);
        }
        return addPersonResponseDtos;
    }

    //get all people who have not taken even a single dose;
    public List<AddPersonResponseDto> getAllWhoHaveNotTakenASingleDose() {
        List<Person> persons=personRepository.getAllWhoHaveNotTakenASingleDose();
        List<AddPersonResponseDto> addPersonResponseDtos=new ArrayList<>();

        //Convert Entity to Response Dto
        for (Person p:persons)
        {
            AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
            addPersonResponseDto.setName(p.getName());
            addPersonResponseDto.setMassege("Not taken a Single Dose.");
            addPersonResponseDtos.add(addPersonResponseDto);
        }
        return addPersonResponseDtos;
    }

    //get all females whose age is greater than a particular age and who have taken only dose 1;
    public List<AddPersonResponseDto> getFemalesWhoseAgeIsGreaterThanAndTakenDose1(int age) {
        List<Person> persons=personRepository.getFemalesWhoseAgeIsGreaterThanAndTakenDose1(age);
        List<AddPersonResponseDto> addPersonResponseDtos=new ArrayList<>();

        //Convert Entity -> Response Dto
        for (Person p:persons)
        {
            AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
            addPersonResponseDto.setName(p.getName());
            addPersonResponseDto.setMassege("Female's age is greater than "+age+" and taken only Dose1.");
            addPersonResponseDtos.add(addPersonResponseDto);
        }
        return addPersonResponseDtos;
    }

    //get all males whose age is greater than a particular age and who have taken both doses;
    public List<AddPersonResponseDto> getMalesWhoseAgeIsGreaterThanAndTakenBothDoses(int age) {
        List<Person> persons=personRepository.getMalesWhoseAgeIsGreaterThanAndTakenBothDoses(age);
        List<AddPersonResponseDto> addPersonResponseDtos=new ArrayList<>();

        //Convert Entity -> Response Dto
        for (Person p:persons)
        {
            AddPersonResponseDto addPersonResponseDto=new AddPersonResponseDto();
            addPersonResponseDto.setName(p.getName());
            addPersonResponseDto.setMassege("Male's age is Greater than "+age+" and taken both Doses");
            addPersonResponseDtos.add(addPersonResponseDto);
        }
        return addPersonResponseDtos;
    }
}
