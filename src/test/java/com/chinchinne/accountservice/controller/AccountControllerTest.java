package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.annotation.AccountTest;
import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.model.AccountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;


@AccountTest
public class AccountControllerTest
{
    @Autowired
    AccountController accountController;

    @Test
    public void wrongDateZeroTest()
    {
        ResponseEntity<List<AccountDto>> account = accountController.getAccounts("967d6988-a1f0-11ed-a8fc-0242ac120002", 123L);

        assertEquals(account.getBody().size(), 0);
    }
}
