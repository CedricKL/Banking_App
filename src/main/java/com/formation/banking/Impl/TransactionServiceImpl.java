package com.formation.banking.Impl;

import com.formation.banking.dto.TransactionDto;
import com.formation.banking.models.TransactionType;
import com.formation.banking.repositories.TransactionRepository;
import com.formation.banking.services.TransactionService;
import com.formation.banking.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final ObjectValidator<TransactionDto> validator;
    @Override
    public Integer save(TransactionDto dto) {
        validator.Validate(dto);
        dto.setAmount(dto.getAmount().multiply(BigDecimal.valueOf(dto.getType() == TransactionType.TRANSFERT? -1:1)));
        return repository.save(TransactionDto.toEntity(dto)).getId();
    }

    @Override
    public List<TransactionDto> findAll() {
        return repository.findAll()
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDto findById(Integer id) {
        return repository.findById(id)
                .map(TransactionDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No transaction exist for this id : " + id));
    }

    @Override
    public void delete(Integer id) {
        // todo check before deleting
        // To follow some security principle, It can be a bad idea to delete a transaction.
        // May be a way to cancel but not delete. So we choose deleting
        repository.deleteById(id);
    }

    @Override
    public List<TransactionDto> findAllByUserId(Integer id) {
        return repository.findAllByUserId(id)
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }
}
