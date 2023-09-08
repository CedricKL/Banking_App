package com.formation.banking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;

    private String role;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
