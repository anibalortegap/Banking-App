package com.example.bankingapp.infrastructure.adapters.outbound.helpers;

import com.example.bankingapp.domain.model.Account;
import com.example.bankingapp.infrastructure.adapters.outbound.entities.AccountEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConverterUtil {

    private ModelMapper modelMapper = new ModelMapper();

    public Account convertEntityToDto(AccountEntity accountEntity){
        return modelMapper.map(accountEntity, Account.class);
    }

    public AccountEntity convertDtoToEntity(Account account){
        return modelMapper.map(account, AccountEntity.class);
    }

    public <T, U> U convertGeneric(T source, Class<U> destination){
        return modelMapper.map(source, destination);
    }
}
