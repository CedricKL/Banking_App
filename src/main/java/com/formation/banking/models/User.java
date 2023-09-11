package com.formation.banking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserApp")
public class User extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private  Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private boolean active;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToOne
    private Account account;

    @OneToOne
    private Address address;

    @OneToOne
    private Role role;


}
