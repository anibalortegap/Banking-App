package com.example.bankingapp.domain.gateway;

import com.example.bankingapp.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountGateway {
    List<Account> getAccounts();
    Account getAccountByNumber(String accountNumber);
    Account createAccount(Account account);
}
