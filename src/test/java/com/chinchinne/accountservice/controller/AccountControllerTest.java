package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.annotation.AccountTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@AccountTest
public class AccountControllerTest
{
    @Autowired
    AccountController accountController;

    @Test
    public void AccountControllerTest()
    {
//        ResponseEntity<List<Account>> account = accountController.getAccount("967d6988-a1f0-11ed-a8fc-0242ac120002");
//
//        account.getBody().forEach( e -> System.out.println(e));
    }
}
