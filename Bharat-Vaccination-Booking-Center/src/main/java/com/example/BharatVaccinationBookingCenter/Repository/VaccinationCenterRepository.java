package com.example.BharatVaccinationBookingCenter.Repository;

import com.example.BharatVaccinationBookingCenter.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}
