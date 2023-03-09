package com.chinchinne.accountservice.service;

import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService
{
    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public List<Account> getAccountByUserId(UserId userId)
    {
        Optional<List<Account>> accounts = accountRepository.findByUserId(userId);

        return accounts.orElseGet(ArrayList::new);
    }
}
