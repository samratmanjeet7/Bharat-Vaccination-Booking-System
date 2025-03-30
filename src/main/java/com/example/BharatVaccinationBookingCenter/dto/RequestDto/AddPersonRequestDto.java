package com.example.BharatVaccinationBookingCenter.dto.RequestDto;

import com.example.BharatVaccinationBookingCenter.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPersonRequestDto {

    String name;

    int age;

    String email;

    Gender gender;
}
