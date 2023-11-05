package com.formation.banking.Impl;

import com.formation.banking.dto.AccountDto;
import com.formation.banking.exceptions.OperationNonPermittedException;
import com.formation.banking.repositories.AccountRepository;
import com.formation.banking.services.AccountService;
import com.formation.banking.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ObjectValidator<AccountDto> validator;
    @Override
    public Integer save(AccountDto dto) {
        // Iban from an account should be generated and cannot be changed after creation
        if(dto.getId() != null)
            throw new OperationNonPermittedException("Account cannot be changed", "Save: " + this.getClass() ,"");
        validator.Validate(dto);
        // generate a random iban
        dto.setIban(generateRandomIban());
        return repository.save(AccountDto.toEntity(dto)).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return repository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No account with the provided id : "+ id));
    }

    @Override
    public void delete(Integer id) {
        // todo check relation with others objects
        repository.deleteById(id);
    }

    //generate a random Iban
    private String generateRandomIban(){
        String iban = Iban.random(CountryCode.FR).toFormattedString();
        if (repository.findByIban(iban).isPresent()) // if the iban already exists
            generateRandomIban(); // recursive way to generate a new iban
        return iban;
    }
}
