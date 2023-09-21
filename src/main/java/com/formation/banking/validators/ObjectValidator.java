package com.formation.banking.validators;


import com.formation.banking.exceptions.ObjectValidationException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void Validate(T objectToValidate){
        Set<ConstraintViolation<T>> violations = validator.validate(objectToValidate);
        if(!violations.isEmpty()){
            Set<String> messages = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());    // Stream uses and lambda
            throw new ObjectValidationException(messages, objectToValidate.getClass().getName());
        }

    }
}
