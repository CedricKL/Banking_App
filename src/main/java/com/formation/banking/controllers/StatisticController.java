package com.formation.banking.controllers;

import com.formation.banking.Impl.StatisticServiceImpl;
import com.formation.banking.dto.TransactionDto;
import com.formation.banking.models.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/statistics")
@RestController
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticServiceImpl statisticService;

    @GetMapping("/{user-id}")
    public ResponseEntity<List<TransactionDto>> getTransactionsByPeriod(
            @PathVariable("user-id") Integer userId,
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime end,
            @RequestParam("type") TransactionType type
            ){
            return ResponseEntity.ok(statisticService.getTransactionsByPeriod(start, end, userId, type));
    }

    @GetMapping("/sum-transactions/{user-id}")
    public ResponseEntity<BigDecimal> getSumTransactionsByPeriod(
            @PathVariable("user-id") Integer userId,
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime end,
            @RequestParam("type") TransactionType type
    ){
        return ResponseEntity.ok(statisticService.getSumTransactionsByPeriod(start, end, userId, type));
    }

    @GetMapping("/account-balance/{user-id}")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(statisticService.getAccountBalance(userId));
    }

    @GetMapping("/highest-transaction/{user-id}")
    public ResponseEntity<BigDecimal> getHighestTransactionByPeriod(
            @PathVariable("user-id") Integer userId,
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime end,
            @RequestParam("type") TransactionType type
    ){
        return ResponseEntity.ok(statisticService.getHighestTransactionByPeriod(start, end, userId, type));
    }
}
