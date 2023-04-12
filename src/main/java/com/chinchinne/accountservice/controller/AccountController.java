package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.dao.AccountDao;
import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.model.Common;
import com.chinchinne.accountservice.domain.value.UserId;
import com.chinchinne.accountservice.exception.CustomException;
import com.chinchinne.accountservice.model.AccountDto;
import com.chinchinne.accountservice.model.ErrorCode;
import com.chinchinne.accountservice.repository.AccountRepository;
import com.chinchinne.accountservice.service.AccountService;
import com.chinchinne.accountservice.spec.AccountSpecs;
import com.chinchinne.accountservice.vo.RequestAccount;
import com.chinchinne.accountservice.vo.RequestParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/")
public class AccountController
{
    AccountDao accountDao;

    AccountRepository accountRepository;

    AccountService accountService;

    ModelMapper modelMapper;

    @Autowired
    public AccountController(AccountService accountService, AccountDao accountDao, AccountRepository accountRepository, ModelMapper modelMapper )
    {
        this.accountService = accountService;
        this.accountDao = accountDao;
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
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

    @GetMapping("{userId}/{date}/account/{accountId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable String userId, @PathVariable Long date, @PathVariable BigInteger accountId)
    {
        LocalDateTime localDateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();

        List<Account> accounts = accountRepository.findAll(AccountSpecs.AccountId(accountId).and(AccountSpecs.DelYn(Common.NO)))
                                                  .orElseGet(ArrayList::new);

        if( accounts.isEmpty() )
        {
            throw new CustomException(ErrorCode.NOT_FOUND_RECORD);
        }

        AccountDto account = modelMapper.map(accounts.get(0), AccountDto.class);

        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @PostMapping("{userId}/{date}/account")
    public ResponseEntity<AccountDto> addAccount(@PathVariable String userId, @PathVariable Long date, @RequestBody @Valid RequestAccount requestAccount)
    {
        LocalDateTime localDateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();

        requestAccount.setUserId(userId);
        requestAccount.setYear(String.valueOf(localDateTime.getYear()));
        requestAccount.setMonth(String.valueOf(localDateTime.getMonthValue()));
        requestAccount.setDay(String.valueOf(localDateTime.getDayOfMonth()));

        AccountDto accountDto = modelMapper.map(requestAccount, AccountDto.class);

        AccountDto res = accountService.createAccount(accountDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping("{userId}/{date}/account")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable String userId, @PathVariable Long date, @RequestBody @Valid RequestAccount requestAccount)
    {
        LocalDateTime localDateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();

        requestAccount.setUserId(userId);
        requestAccount.setYear(String.valueOf(localDateTime.getYear()));
        requestAccount.setMonth(String.valueOf(localDateTime.getMonthValue()));
        requestAccount.setDay(String.valueOf(localDateTime.getDayOfMonth()));

        AccountDto accountDto = modelMapper.map(requestAccount, AccountDto.class);

        AccountDto res = accountService.changeAccount(accountDto);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("{userId}/{date}/account")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable String userId, @PathVariable Long date, @RequestBody RequestAccount requestAccount)
    {
        LocalDateTime localDateTime = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDateTime();

        requestAccount.setUserId(userId);
        requestAccount.setYear(String.valueOf(localDateTime.getYear()));
        requestAccount.setMonth(String.valueOf(localDateTime.getMonthValue()));
        requestAccount.setDay(String.valueOf(localDateTime.getDayOfMonth()));

        AccountDto accountDto = modelMapper.map(requestAccount, AccountDto.class);

        AccountDto res = accountService.removeAccount(accountDto);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


}
