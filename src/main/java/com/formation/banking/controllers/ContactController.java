package com.formation.banking.controllers;

import com.formation.banking.Impl.ContactServiceImpl;
import com.formation.banking.dto.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/contacts")
@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactServiceImpl contactService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.save(contactDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll(){
        return ResponseEntity.ok(contactService.findAll());
    }

    @GetMapping("/{contact-id}")
    public ResponseEntity<ContactDto> findAById(@PathVariable("contact-id") Integer contactId){
        return ResponseEntity.ok(contactService.findById(contactId));
    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity<List<ContactDto>> findAllByUser(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(contactService.findAllByUser(userId));
    }

    @DeleteMapping("/{contact-id}")
    public ResponseEntity<Void> delete(@PathVariable("contact-id") Integer contactId){
        contactService.delete(contactId);
        return ResponseEntity.accepted().build();  // to show that our request has been treated
    }
}
