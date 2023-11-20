package com.formation.banking.handler;

// this class is used to have a unique object representation to send to consumers for each exception

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Set;

@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionRepresentation {
    private String errorMsg;
    private String errorSource;
    private Set<String> violations;
}
