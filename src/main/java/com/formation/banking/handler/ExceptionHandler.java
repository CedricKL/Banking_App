package com.formation.banking.handler;

import com.formation.banking.exceptions.ObjectValidationException;
import com.formation.banking.exceptions.OperationNonPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> exceptionHandler(ObjectValidationException exception){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMsg("Object not valid")
                .errorSource(exception.getErrorSource())
                .violations(exception.getErrorMessages())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(representation);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> exceptionHandler(EntityNotFoundException exception){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMsg(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(representation);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(OperationNonPermittedException.class)
    public ResponseEntity<ExceptionRepresentation> exceptionHandler(OperationNonPermittedException exception){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMsg(exception.getMessage())
                .errorSource(exception.getSource())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(representation);
    }
}
