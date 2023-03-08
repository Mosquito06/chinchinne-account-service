package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.AccountServiceApplication;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@AccountTest
public class AccountServiceTest
{
    @Autowired
    AccountService accountService;


    @Test
    public void getAccountTest()
    {
        UserId userId = new UserId("967d6988-a1f0-11ed-a8fc-0242ac120002");

         accountService.getAccountByUserId(userId);


    }

}
