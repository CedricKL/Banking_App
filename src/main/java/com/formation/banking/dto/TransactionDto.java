package com.formation.banking.dto;

import com.formation.banking.models.Transaction;
import com.formation.banking.models.TransactionType;
import com.formation.banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactionDto {

    private Integer id;

    private BigDecimal amount;

    private String destinationIban;

    private TransactionType type;

    private Integer userId;

    public static TransactionDto fromEntity(Transaction transaction){
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .destinationIban(transaction.getDestinationIban())
                .type(transaction.getType())
                .userId(transaction.getUser().getId())
                .build();
    }

    public static Transaction toEntity(TransactionDto transaction){
        return Transaction.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .DestinationIban(transaction.getDestinationIban())
                .type(transaction.getType())
                .user(
                        User.builder()
                            .id(transaction.getUserId())
                            .build()
                )
                .build();
    }
}
