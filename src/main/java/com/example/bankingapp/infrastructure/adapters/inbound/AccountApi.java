package com.example.bankingapp.infrastructure.adapters.inbound;

import com.example.bankingapp.domain.model.Account;
import com.example.bankingapp.domain.usecase.AccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AccountApi {

    private final AccountUseCase accountUseCase;

    @GetMapping(path = "/account")
    public List<Account> getAccounts(){
        return accountUseCase.getAccounts();
    }

    @GetMapping(path = "/account/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber){
        return accountUseCase.getAccountById(accountNumber);
    }

    @PostMapping(path = "/account")
    public Account createAccount(@RequestBody Account account){
        return accountUseCase.createAccount(account);
    }
}
