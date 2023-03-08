package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;

@ExtendWith( MockitoExtension.class )
public class AccountRepositoryTest
{
    @Mock
    AccountRepository accountRepository;

    @Test
    public void getAccountTest()
    {
        //UserId userId = new UserId("testId");
        accountRepository.findByUserId(any());

        BDDMockito.then(accountRepository).should(only()).findByUserId(any());

//        UserId userId = new UserId("967d6988-a1f0-11ed-a8fc-0242ac120002");
//
//        Optional<List<Account>> accounts = accountRepository.findByUserId(userId);
//        accounts.to

    }
}
