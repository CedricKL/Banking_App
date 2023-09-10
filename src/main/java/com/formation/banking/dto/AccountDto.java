package com.formation.banking.dto;

import com.formation.banking.models.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AccountDto {

    private Integer id;

    private String iban;

    private UserDto userDto;

    public static AccountDto fromEntity(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .iban(account.getIban())
                .userDto(UserDto.fromEntity(account.getUser()))
                .build();
    }

    public static Account toEntity(AccountDto account){
        return Account.builder()
                .id(account.getId())
                .iban(account.getIban())
                .user(UserDto.toEntity(account.getUserDto()))
                .build();
    }
}
