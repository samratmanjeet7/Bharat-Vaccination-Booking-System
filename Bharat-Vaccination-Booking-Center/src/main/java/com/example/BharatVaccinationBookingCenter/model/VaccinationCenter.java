package com.example.BharatVaccinationBookingCenter.model;

import com.example.BharatVaccinationBookingCenter.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String centerName;

    @Enumerated(value = EnumType.STRING)
    CenterType centerType;

    String address;

    @OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
    List<Doctor> doctors=new ArrayList<>();

}
