package com.formation.banking.controllers;

import com.formation.banking.Impl.StatisticServiceImpl;
import com.formation.banking.dto.TransactionDto;
import com.formation.banking.models.TransactionType;
import lombok.RequiredArgsConstructor;
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
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end,
            @RequestParam("type") TransactionType type
            ){
            return ResponseEntity.ok(statisticService.getTransactionsByPeriod(start, end, userId, type));
    }

    @GetMapping("/account-balance/{user-id}")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(statisticService.getAccountBalance(userId));
    }

    @GetMapping("/highest-transaction/{user-id}")
    public ResponseEntity<BigDecimal> getHighestTransactionByPeriod(
            @PathVariable("user-id") Integer userId,
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end,
            @RequestParam("type") TransactionType type
    ){
        return ResponseEntity.ok(statisticService.getHighestTransactionByPeriod(start, end, userId, type));
    }
}
