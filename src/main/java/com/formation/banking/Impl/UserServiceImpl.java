package com.formation.banking.Impl;

import com.formation.banking.dto.AccountDto;
import com.formation.banking.dto.UserDto;
import com.formation.banking.models.User;
import com.formation.banking.repositories.UserRepository;
import com.formation.banking.services.AccountService;
import com.formation.banking.services.UserService;
import com.formation.banking.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // we use a constructor to let Spring manage the injection of some beans
public class UserServiceImpl implements UserService {

    private final UserRepository repository; //autowired by Spring
    private final AccountService accountService;
    private final ObjectValidator<UserDto> validator; //autowired by Spring

    @Override
    public Integer save(UserDto dto) {
        validator.Validate(dto); //before saving, we need to check what we validate !
        return repository.save(UserDto.toEntity(dto)).getId();
    }

    @Override
    public List<UserDto> findAll() {
        // we must convert before returning because the repository gets User not UserDto
        return repository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return repository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No entity found for the provided id: " + id)); // we raise an exception if the id doesn't match with any object
    }

    @Override
    public void delete(Integer id) {
        // todo check relation with others objects
        repository.deleteById(id);
    }

    @Override
    public Integer validateAccount(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No user found for this id : " + id));
        AccountDto dto = AccountDto.builder()
                .userDto(UserDto.fromEntity(user))
                .build();
        Integer accountId = accountService.save(dto);
        user.setActive(true);
        repository.save(user);
        return accountId;
    }

    @Override
    public Integer invalidateAccount(Integer id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No user found for this id : " + id));
        user.setActive(true);
        repository.save(user);
        return user.getId();
    }
}
