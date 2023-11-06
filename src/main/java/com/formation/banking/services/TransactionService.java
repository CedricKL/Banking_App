package com.formation.banking.services;

import com.formation.banking.dto.TransactionDto;

import java.util.List;

public interface TransactionService extends AbstractServices<TransactionDto>{

    List<TransactionDto> findAllByUserId(Integer id);
}
