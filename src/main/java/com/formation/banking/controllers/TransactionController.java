package com.formation.banking.controllers;

import com.formation.banking.Impl.TransactionServiceImpl;
import com.formation.banking.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/transactions")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionServiceImpl transactionService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody TransactionDto transactionDto){
        return ResponseEntity.ok(transactionService.save(transactionDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> findAll(){
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{transaction-id}")
    public ResponseEntity<TransactionDto> findAById(@PathVariable("transaction-id") Integer transactionId){
        return ResponseEntity.ok(transactionService.findById(transactionId));
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<List<TransactionDto>> findAllByUser(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(transactionService.findAllByUserId(userId));
    }

    @DeleteMapping("/{transaction-id}")
    public ResponseEntity<Void> delete(@PathVariable("transaction-id") Integer transactionId){
        transactionService.delete(transactionId);
        return ResponseEntity.accepted().build();  // to show that our request has been treated
    }
}
