package com.chinchinne.accountservice.service;

import com.chinchinne.accountservice.annotation.AccountTest;
import com.chinchinne.accountservice.domain.value.UserId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
