package com.formation.banking.Impl;

import com.formation.banking.dto.ContactDto;
import com.formation.banking.repositories.ContactRepository;
import com.formation.banking.services.ContactService;
import com.formation.banking.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;
    private final ObjectValidator<ContactDto> validator;

    @Override
    public Integer save(ContactDto dto) {
        validator.Validate(dto);
        return repository.save(ContactDto.toEntity(dto)).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return repository.findAll()
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Integer id) {
        return repository.findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No contact found with the provided id: " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check before delete
        repository.deleteById(id);
    }
}
