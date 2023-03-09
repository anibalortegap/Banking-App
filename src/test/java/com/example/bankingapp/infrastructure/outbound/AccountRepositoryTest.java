package com.example.bankingapp.infrastructure.outbound;

import com.example.bankingapp.infrastructure.adapters.outbound.AccountRepository;
import com.example.bankingapp.infrastructure.adapters.outbound.entities.AccountEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @Rollback(value = false)
    public void create_an_account(){
        AccountEntity account = AccountEntity.builder()
                .id(3L)
                .accountNumber("12345")
                .balance(new BigDecimal(100))
                .build();

        AccountEntity accountSave = accountRepository.save(account);
        Assertions.assertNotNull(accountSave);
    }

    @Test
    public void findAccountByName(){
        String accountNumber = "12345";
        Optional<AccountEntity> account = accountRepository.findByAccountNumber(accountNumber);
        Assertions.assertNotNull(account);
    }

    @Test
    public void finAll(){
        List<AccountEntity> accountAll = accountRepository.findAll();
        Assertions.assertEquals(Arrays.asList(
                new AccountEntity(1L,"024779", new BigDecimal(1000000)),
                new AccountEntity(2L,"412789", new BigDecimal(10000000)),
                new AccountEntity(3L,"12345", new BigDecimal(100))), accountAll);
    }
}
