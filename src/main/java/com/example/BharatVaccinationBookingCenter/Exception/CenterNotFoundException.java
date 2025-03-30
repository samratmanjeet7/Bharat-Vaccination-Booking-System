package com.example.BharatVaccinationBookingCenter.Exception;

public class CenterNotFoundException extends  RuntimeException{

    public CenterNotFoundException(String message)
    {
        super(message);
    }
}
