package com.chinchinne.accountservice.service;

import com.chinchinne.accountservice.annotation.AccountTest;
import com.chinchinne.accountservice.domain.model.Status;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.exception.CustomException;
import com.chinchinne.accountservice.model.AccountDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

@AccountTest
public class AccountServiceTest
{
    @Autowired
    AccountService accountService;


    @Test
    public void getAccountTest()
    {
        UserId userId = new UserId("967d6988-a1f0-11ed-a8fc-0242ac120002");

        //accountService.getAccountByUserId(userId);
    }

    @Test
    public void saveTransactionTest()
    {
        AccountDto accountDto = new AccountDto();
        accountDto.setUserId("967d6988-a1f0-11ed-a8fc-0242ac120002");
        accountDto.setYear("2023");
        accountDto.setMonth("4");
        accountDto.setDay("20");
        accountDto.setCategory("1");
        accountDto.setStatus(Status.EXPENSE);
        accountDto.setMemo("롤백 테스트");
        accountDto.setAmount(BigInteger.valueOf(12500));

//        Assertions.assertThrows(CustomException.class, () ->
//        {
//            accountService.createAccount(accountDto);
//        });
    }
}
