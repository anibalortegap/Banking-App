package com.example.bankingapp.infrastructure.adapters.outbound;

import com.example.bankingapp.domain.model.Account;
import com.example.bankingapp.domain.gateway.AccountGateway;
import com.example.bankingapp.infrastructure.adapters.outbound.entities.AccountEntity;
import com.example.bankingapp.infrastructure.adapters.outbound.helpers.ConverterUtil;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountGateway {

    private static final Logger log = Logger.getLogger(AccountRepositoryAdapter.class.getName());

    private final AccountRepository accountRepository;

    private final ModelMapper mapper;

    @Override
    public List<Account> getAccounts() {
       return accountRepository.findAll().stream().map(accountEntity -> Account.builder()
                       .id(accountEntity.getId())
                       .accountNumber(accountEntity.getAccountNumber())
                       .balance(accountEntity.getBalance())
               .build()).collect(Collectors.toList());

    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .map(accountEntity -> mapper.map(accountEntity, Account.class))
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public Account createAccount(Account account) {
        AccountEntity accountEntity = AccountEntity.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .build();
        return mapper.map(accountRepository.save(accountEntity), Account.class);
    }
}
