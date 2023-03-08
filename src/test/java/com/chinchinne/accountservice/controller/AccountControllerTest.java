package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.AccountServiceApplication;
import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.value.UserId;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


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
