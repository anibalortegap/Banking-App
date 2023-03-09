package com.example.bankingapp.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
}
