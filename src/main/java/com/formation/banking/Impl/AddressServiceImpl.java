package com.formation.banking.Impl;

import com.formation.banking.dto.AddressDto;
import com.formation.banking.repositories.AddressRepository;
import com.formation.banking.services.AddressService;
import com.formation.banking.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final ObjectValidator<AddressDto> validator;

    @Override
    public Integer save(AddressDto dto) {
        validator.Validate(dto);
        return repository.save(AddressDto.toEntity(dto)).getId();
    }

    @Override
    public List<AddressDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AddressDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Integer id) {
        return repository.findById(id)
                .map(AddressDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No address was found for this id : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check relations before deleting
        repository.deleteById(id);
    }
}
