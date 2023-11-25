package com.formation.banking.controllers;

import com.formation.banking.Impl.AddressServiceImpl;
import com.formation.banking.dto.AddressDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/addresses")
@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressServiceImpl addressService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AddressDto addressDto){
        return ResponseEntity.ok(addressService.save(addressDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AddressDto>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<AddressDto> findAById(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(addressService.findById(userId));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> delete(@PathVariable("user-id") Integer userId){
        addressService.delete(userId);
        return ResponseEntity.accepted().build();  // to show that our request has been treated
    }
}
