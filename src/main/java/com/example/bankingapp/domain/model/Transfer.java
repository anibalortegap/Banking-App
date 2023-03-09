package com.example.bankingapp.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    @NonNull
    private Long id;
    @NonNull
    private String senderAccount;
    @NonNull
    private String recipientAccount;
    @NonNull
    private BigDecimal amount;
    private String transactionRef;
}
