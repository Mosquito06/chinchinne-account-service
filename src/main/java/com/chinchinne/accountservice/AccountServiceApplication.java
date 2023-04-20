package com.chinchinne.accountservice;

import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.model.AccountDto;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper()
    {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Account.class, AccountDto.class).addMappings( mapping ->
        {
            mapping.map(Account::getAccountId, AccountDto::setAccountId);
            mapping.map( row -> row.getUserId().getId(), AccountDto::setUserId);
            mapping.map( row -> row.getAccountDate().getYear()  , AccountDto::setYear);
            mapping.map( row -> row.getAccountDate().getMonth()  , AccountDto::setMonth);
            mapping.map( row -> row.getAccountDate().getDay()  , AccountDto::setDay);
            mapping.map( row -> String.valueOf(row.getCategoryId().getId()) , AccountDto::setCategory);
            mapping.map(Account::getStatus, AccountDto::setStatus);
            mapping.map(Account::getMemo, AccountDto::setMemo);
            mapping.map(Account::getAmount, AccountDto::setAmount);
        });

        return modelMapper;
    }
}