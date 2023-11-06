package com.formation.banking.repositories;

import com.formation.banking.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findAllByUserId(Integer userId);
}
