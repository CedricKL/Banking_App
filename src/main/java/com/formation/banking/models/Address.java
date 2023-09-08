package com.formation.banking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    private String country;

    private String city;

    private String street;

    private String zipCode;

    private Integer houseNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
