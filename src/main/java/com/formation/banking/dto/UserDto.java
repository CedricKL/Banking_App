package com.formation.banking.dto;

import com.formation.banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;

    @NotNull(message = "firstname must be provided")
    @NotEmpty(message = "please enter a valid firstname")
    @NotBlank(message = "please enter a valid firstname")
    private String firstname;

    @NotNull(message = "lastname must be provided")
    @NotEmpty(message = "please enter a valid lastname")
    @NotBlank(message = "please enter a valid lastname")
    private String lastname;

    @Email(message = "You must enter a valid email like this.is.an@example.com")
    private String email;

    @Size(min = 8,message = "password size must be greater than 8")
    @NotBlank(message = "please enter a valid password")
    private String password;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto user){
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
