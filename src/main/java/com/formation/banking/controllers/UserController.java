package com.formation.banking.controllers;

import com.formation.banking.dto.UserDto;
import com.formation.banking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")  //the general url to map to this controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<Integer> save (@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserDto> findById( @PathVariable("user-id") Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> delete(@PathVariable("user-id") Integer id){
        userService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/validate/{user-id}")
    public ResponseEntity<Integer> validate(@PathVariable("user-id") Integer id){
        return ResponseEntity.ok(userService.validateAccount(id));
    }

    @GetMapping("/invalidate/{user-id}")
    public ResponseEntity<Integer> invalidate(@PathVariable("user-id") Integer id){
        return ResponseEntity.ok(userService.invalidateAccount(id));
    }
}
