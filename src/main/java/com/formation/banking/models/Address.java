package com.formation.banking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;

    private String country;

    private String city;

    private String street;

    private String zipCode;

    private Integer houseNumber;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
