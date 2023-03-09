package com.example.bankingapp.domain.usecase.account;

import com.example.bankingapp.domain.gateway.AccountGateway;
import com.example.bankingapp.domain.gateway.TransferGateway;
import com.example.bankingapp.domain.model.Account;
import com.example.bankingapp.domain.model.Transfer;
import com.example.bankingapp.domain.model.TransferResponse;
import com.example.bankingapp.domain.usecase.AccountUseCase;
import com.example.bankingapp.domain.usecase.TransferUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class AccountUseCaseTest {

    private Account account;
    private final String ACCOUNT_NUMBER = "09876";
    private List<Account> accountResponse = new ArrayList<>();
    @InjectMocks
    private AccountUseCase accountUseCase;
    @Mock
    private AccountGateway gateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        account = Account.builder()
                .id(1L)
                .accountNumber("09876")
                .balance(new BigDecimal(10000))
                .build();

        accountResponse = Arrays.asList(
                new Account(1L, "12345", new BigDecimal(1000)),
                new Account(2L, "09876", new BigDecimal(1400)));
    }


    @Test
    void saveAccountOk(){
        Mockito.when(gateway.createAccount(account)).thenReturn(account);
        Account response = accountUseCase.createAccount(account);
        Assertions.assertEquals(account, response);
    }

    @Test
    void returnAllAccount(){
        Mockito.when(gateway.getAccounts()).thenReturn(accountResponse);
        Collection<Account> response = accountUseCase.getAccounts();
        Assertions.assertEquals(accountResponse, response);
    }

    @Test
    void returnAccountByNumber(){
        Mockito.when(gateway.getAccountByNumber(ACCOUNT_NUMBER)).thenReturn(account);
        Account response = accountUseCase.getAccountById(ACCOUNT_NUMBER);
        Assertions.assertEquals(account, response);
    }

    private List<String> getAccountIds(Collection<Account> accounts){
        List<String> accountsNumbers = accounts.stream().map(Account::getAccountNumber).collect(Collectors.toList());
        return accountsNumbers;
    }
}
