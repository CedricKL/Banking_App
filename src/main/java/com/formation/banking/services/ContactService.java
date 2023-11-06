package com.formation.banking.services;

import com.formation.banking.dto.ContactDto;

import java.util.List;

public interface ContactService extends AbstractServices<ContactDto> {

    List<ContactDto> findAllByUser(Integer id);
}
