package com.example.BharatVaccinationBookingCenter.Exception;

public class DoseAlreadyTakenException extends RuntimeException{

    public DoseAlreadyTakenException(String message)
    {
        super(message);
    }
}
