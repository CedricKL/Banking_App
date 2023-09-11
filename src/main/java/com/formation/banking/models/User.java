package com.formation.banking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotNull(message = "field must be fill")
    @NotEmpty(message = "please enter a valid name")
    @NotBlank(message = "please enter a valid name")
    private String firstname;

    @NotNull(message = "field must be fill")
    @NotEmpty(message = "please enter a valid name")
    @NotBlank(message = "please enter a valid name")
    private String lastname;

    @Email(message = "You must enter a valid email like this.is.an@example.com")
    private String email;

    @Size(min = 8)
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
