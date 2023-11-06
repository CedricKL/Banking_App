package com.formation.banking.services;

import com.formation.banking.dto.UserDto;

// this class is used to respect in a certain way the opened-closed principle
public interface UserService extends AbstractServices<UserDto>{

    Integer validateAccount(Integer id); // active a user account by creating its bank account
    Integer invalidateAccount(Integer id); // invalid a user account
}
