package com.example.bankingapp.infrastructure.adapters.outbound.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AccountEntity {

    private static final long serialVersionUID = 4471777119419172870L;
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "balance")
    private BigDecimal balance;

    public void credit(BigDecimal amount){
        balance = balance.add(amount);
    }

    public void debit(BigDecimal amount){
        balance = balance.subtract(amount);
    }

}
