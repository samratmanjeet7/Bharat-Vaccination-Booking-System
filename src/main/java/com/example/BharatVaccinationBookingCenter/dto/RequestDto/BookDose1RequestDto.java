package com.example.BharatVaccinationBookingCenter.dto.RequestDto;

import com.example.BharatVaccinationBookingCenter.Enum.DoseType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDose1RequestDto {

    int personId;

    DoseType doseType;
}
