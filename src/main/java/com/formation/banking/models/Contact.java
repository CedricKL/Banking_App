package com.formation.banking.models;

import javax.persistence.*;
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
public class Contact extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private  Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String iban;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
