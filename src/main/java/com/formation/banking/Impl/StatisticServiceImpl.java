package com.formation.banking.Impl;

import com.formation.banking.dto.TransactionDto;
import com.formation.banking.models.TransactionType;
import com.formation.banking.repositories.TransactionRepository;
import com.formation.banking.services.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final TransactionRepository transactionRepository;
    @Override
    public List<TransactionDto> getTransactionsByPeriod(LocalDateTime start, LocalDateTime end, Integer userId, TransactionType type) {
        return transactionRepository.findAllTransactionByPeriod(start, end, userId, type)
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getAccountBalance(Integer userId) {
        return transactionRepository.findBalance(userId);
    }

    @Override
    public BigDecimal getHighestTransactionByPeriod(LocalDateTime start, LocalDateTime end, Integer userId, TransactionType type) {
        return transactionRepository.findHighestTransaction(start, end, userId, type);
    }

    @Override
    public BigDecimal getSumTransactionsByPeriod(LocalDateTime start, LocalDateTime end, Integer userId, TransactionType type) {
        return transactionRepository.findSumTransactionSByPeriod(start,end,userId,type);
    }
}
