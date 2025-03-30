package com.example.BharatVaccinationBookingCenter.Repository;

import com.example.BharatVaccinationBookingCenter.model.Dose;
import com.example.BharatVaccinationBookingCenter.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
