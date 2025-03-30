package com.example.BharatVaccinationBookingCenter.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String certificateNo;

    String confirmationMessage;

    @OneToOne
    @JoinColumn//for the representation of foreign key
    Person person;
}
