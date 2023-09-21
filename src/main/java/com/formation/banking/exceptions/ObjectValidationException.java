package com.formation.banking.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

/**
 * This is an exception raise in case of violation
 * It's help to have more information than the generic ones given by the dependencies **/
@RequiredArgsConstructor
@Getter
public class ObjectValidationException extends RuntimeException{

    private final Set<String> errorMessages;

    private final String errorSource;
}
