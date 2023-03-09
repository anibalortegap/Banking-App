package com.example.bankingapp.domain.usecase;

import com.example.bankingapp.domain.model.Account;
import com.example.bankingapp.domain.gateway.AccountGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AccountUseCase {

    private final AccountGateway accountGateway;

    public List<Account> getAccounts() {
        return accountGateway.getAccounts();
    }


    public Account getAccountById(String accountNumber) {
        return accountGateway.getAccountByNumber(accountNumber);
    }

    public Account createAccount(Account account) {
        return accountGateway.createAccount(account);
    }
}
