package com.chinchinne.accountservice.service;

import com.chinchinne.accountservice.config.TransactionConfig;
import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.model.Common;
import com.chinchinne.accountservice.domain.value.AccountDate;
import com.chinchinne.accountservice.domain.value.CategoryId;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.exception.CustomException;
import com.chinchinne.accountservice.model.AccountDto;
import com.chinchinne.accountservice.model.ErrorCode;
import com.chinchinne.accountservice.repository.mongo.AccountMongoRepository;
import com.chinchinne.accountservice.repository.jpa.AccountRepository;
import com.chinchinne.accountservice.spec.AccountSpecs;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService
{
    ModelMapper modelMapper;

    AccountRepository accountRepository;

    AccountMongoRepository accountMongoRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMongoRepository accountMongoRepository, ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
        this.accountRepository = accountRepository;
        this.accountMongoRepository = accountMongoRepository;
    }

//    @Transactional
//    public List<Account> getAccountByUserId(UserId userId)
//    {
//        Optional<List<Account>> accounts = accountRepository.findByUserId(userId);
//
//        return accounts.orElseGet(ArrayList::new);
//    }

    @Transactional( value = TransactionConfig.TRANSACTION_MANAGER )
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
        accountMongoRepository.save(account);

        return modelMapper.map(account, AccountDto.class);
    }

    @Transactional( value = TransactionConfig.TRANSACTION_MANAGER )
    public AccountDto changeAccount(AccountDto accountDto)
    {
        List<Account> accounts = accountRepository.findAll(AccountSpecs.AccountId(accountDto.getAccountId()).and(AccountSpecs.DelYn(Common.NO)))
                                                  .orElseGet(ArrayList::new);

        if( accounts.isEmpty() )
        {
            throw new CustomException(ErrorCode.NOT_FOUND_RECORD);
        }

        Account account = accounts.get(0);
        account.changeAccount
        (
             new UserId(accountDto.getUserId())
            ,new CategoryId(BigInteger.valueOf( Long.parseLong(accountDto.getCategory()) ))
            ,accountDto.getStatus()
            ,accountDto.getMemo()
            ,accountDto.getAmount()
        );

        return modelMapper.map(account, AccountDto.class);
    }

    @Transactional( value = TransactionConfig.TRANSACTION_MANAGER )
    public AccountDto removeAccount(AccountDto accountDto)
    {
        List<Account> accounts = accountRepository.findAll(AccountSpecs.AccountId(accountDto.getAccountId()).and(AccountSpecs.DelYn(Common.NO)))
                                                  .orElseGet(ArrayList::new);

        if( accounts.isEmpty() )
        {
            throw new CustomException(ErrorCode.NOT_FOUND_RECORD);
        }

        Account account = accounts.get(0);
        account.removeAccount
        (
             new UserId(accountDto.getUserId())
            ,Common.YES
        );

        return modelMapper.map(account, AccountDto.class);
    }

}
