package com.example.BharatVaccinationBookingCenter.Repository;

import com.example.BharatVaccinationBookingCenter.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
