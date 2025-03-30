package com.example.BharatVaccinationBookingCenter.dto.ResponseDto;

import com.example.BharatVaccinationBookingCenter.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CenterResponseDto {

    String centerName;

    CenterType centerType;

    String address;
}
