package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AccountController
{
    AccountService accountService;

    @Autowired
    public AccountController( AccountService accountService )
    {
        this.accountService = accountService;
    }

    @GetMapping("{userId}/accounts")
    public ResponseEntity<List<Account>> getAccount(@PathVariable String userId)
    {
        List<Account> account = accountService.getAccountByUserId(new UserId(userId));

        return ResponseEntity.status(HttpStatus.OK).body(account);
    }
}
