package com.formation.banking.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EntityViolationException extends RuntimeException{
    private final String entityName;
}
