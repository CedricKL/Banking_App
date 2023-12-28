package com.formation.banking.repositories;


import com.formation.banking.models.Transaction;
import com.formation.banking.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findAllByUserId(Integer userId);

    @Query("from Transaction t where t.user.id = :userId and t.type = :type and t.creationDate between :start and :end")
    List<Transaction> findAllTransactionByPeriod(LocalDateTime start, LocalDateTime end, Integer userId, TransactionType type);

    @Query("select sum(t.amount) from Transaction t where t.user.id = :userId")
    BigDecimal findBalance(Integer userId);

    @Query("select max(abs(t.amount)) from Transaction t where t.user.id = :userId and t.type = :type and (t.creationDate between :start and :end)")
    BigDecimal findHighestTransaction(LocalDateTime start, LocalDateTime end, Integer userId, TransactionType type);

    @Query("select sum(abs(t.amount)) from Transaction t where t.user.id = :userId and t.type = :type and (t.creationDate between :start and :end)")
    BigDecimal findSumTransactionSByPeriod(LocalDateTime start, LocalDateTime end, Integer userId, TransactionType type);
}
