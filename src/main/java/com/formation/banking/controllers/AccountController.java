package com.formation.banking.controllers;

import com.formation.banking.Impl.AccountServiceImpl;
import com.formation.banking.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/accounts")
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<AccountDto> findAById(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(accountService.findById(userId));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> delete(@PathVariable("user-id") Integer userId){
        accountService.delete(userId);
        return ResponseEntity.accepted().build();  // to show that our request has been treated
    }
}
