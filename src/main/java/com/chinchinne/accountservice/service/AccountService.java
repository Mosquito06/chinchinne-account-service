package com.chinchinne.accountservice.service;

import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.model.Common;
import com.chinchinne.accountservice.domain.model.Status;
import com.chinchinne.accountservice.domain.value.AccountDate;
import com.chinchinne.accountservice.domain.value.CategoryId;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.model.AccountDto;
import com.chinchinne.accountservice.repository.AccountRepository;
import com.chinchinne.accountservice.vo.RequestAccount;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService
{
    ModelMapper modelMapper;

    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public List<Account> getAccountByUserId(UserId userId)
    {
        Optional<List<Account>> accounts = accountRepository.findByUserId(userId);

        return accounts.orElseGet(ArrayList::new);
    }

    @Transactional
    public AccountDto createAccount(AccountDto accountDto)
    {
        Account account = new Account
        (
             new UserId(accountDto.getUserId())
            ,new AccountDate(accountDto.getYear(), accountDto.getMonth(), accountDto.getDay())
            ,new CategoryId(BigInteger.valueOf( Long.parseLong(accountDto.getCategory()) ))
            ,accountDto.getStatus()
            ,accountDto.getMemo()
            ,accountDto.getAmount()
            ,Common.NO
        );

        accountRepository.save(account);

        return modelMapper.map(account, AccountDto.class);
    }

}
