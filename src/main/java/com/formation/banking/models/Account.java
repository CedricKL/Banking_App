package com.formation.banking.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private  Integer id;

    private String iban;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
