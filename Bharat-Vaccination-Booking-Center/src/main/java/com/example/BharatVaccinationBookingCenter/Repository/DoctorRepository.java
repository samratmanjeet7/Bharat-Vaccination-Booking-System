package com.example.BharatVaccinationBookingCenter.Repository;

import com.example.BharatVaccinationBookingCenter.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    //@Query(value="select d from doctor as d where age>:age")
    //List<Doctor> getByAgeGreaterThan(int age);
    //d is the doctor object
    @Query(value = "select * from doctor where age> :age",nativeQuery = true)
    List<Doctor> getByAgeGreaterThan(int age);
}
