package com.example.bankingapp.infrastructure.adapters.outbound.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "account_transfer")
@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferEntity {
    @Id
    private Long id;
    @Column(name = "account_sender")
    private String senderAccount;
    @Column(name = "account_recipient")
    private String recipientAccount;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "transaction_ref")
    private String transactionRef;

}
