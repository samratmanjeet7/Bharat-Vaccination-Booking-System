package com.example.BharatVaccinationBookingCenter.dto.RequestDto;

import com.example.BharatVaccinationBookingCenter.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CenterRequestDto {

    String centerName;

    CenterType centerType;

    String address;
}
