package com.formation.banking.models;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private  Integer id;

    private String iban;

//    private LocalDateTime creationDate;
//
//    private LocalDateTime lastUpdate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
