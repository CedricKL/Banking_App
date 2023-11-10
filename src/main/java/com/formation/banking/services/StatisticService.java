package com.formation.banking.services;


import com.formation.banking.dto.TransactionDto;
import com.formation.banking.models.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface StatisticService {

    List<TransactionDto> getTransactionsByPeriod(LocalDateTime start, LocalDateTime end, Integer userId, TransactionType type);

    BigDecimal getAccountBalance(Integer userId);

    BigDecimal getHighestTransactionByPeriod(LocalDateTime start, LocalDateTime end, Integer userId, TransactionType type);
}
