package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.dao.AccountDao;
import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.model.AccountDto;
import com.chinchinne.accountservice.service.AccountService;
import com.chinchinne.accountservice.vo.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/")
public class AccountController
{
    AccountDao accountDao;

    AccountService accountService;

    @Autowired
    public AccountController( AccountService accountService, AccountDao accountDao )
    {
        this.accountService = accountService;
        this.accountDao = accountDao;
    }

    @GetMapping("{userId}/{date}/accounts")
    public ResponseEntity<List<AccountDto>> getAccounts(@PathVariable String userId, @PathVariable Long date)
    {
        LocalDateTime localDateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();

        RequestParam req = RequestParam.builder()
                                        .userId(userId)
                                        .year(String.valueOf(localDateTime.getYear()))
                                        .month(String.valueOf(localDateTime.getMonthValue()))
                                        .build();

        List<AccountDto> account = accountDao.getAccountsByRequestParam(req);

        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @GetMapping("{userId}/{date}/account")
    public ResponseEntity<List<AccountDto>> getAccount(@PathVariable String userId, @PathVariable Long date)
    {
        LocalDateTime localDateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();

        RequestParam req = RequestParam.builder()
                                        .userId(userId)
                                        .year(String.valueOf(localDateTime.getYear()))
                                        .month(String.valueOf(localDateTime.getMonthValue()))
                                        .day(String.valueOf(localDateTime.getDayOfMonth()))
                                        .build();

        List<AccountDto> account = accountDao.getAccountByRequestParam(req);

        return ResponseEntity.status(HttpStatus.OK).body(account);
    }
}
