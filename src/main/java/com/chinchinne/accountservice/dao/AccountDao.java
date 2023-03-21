package com.chinchinne.accountservice.dao;

import com.chinchinne.accountservice.model.AccountDto;
import com.chinchinne.accountservice.vo.RequestParam;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AccountDao
{
    public List<AccountDto> getAccountsByRequestParam(RequestParam requestParam);
    public List<AccountDto> getAccountByRequestParam(RequestParam requestParam);
}
