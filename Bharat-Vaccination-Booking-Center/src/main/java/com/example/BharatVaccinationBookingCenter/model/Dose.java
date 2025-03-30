package com.example.BharatVaccinationBookingCenter.model;

import com.example.BharatVaccinationBookingCenter.Enum.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String doseId;//Generate this using uuid

    @Enumerated(value = EnumType.STRING)
    DoseType doseType;

    @CreationTimestamp//that date will be auto generated at the time of dose object creation
    Date vaccinationDate;

    @ManyToOne
    @JoinColumn
    Person person;
}
