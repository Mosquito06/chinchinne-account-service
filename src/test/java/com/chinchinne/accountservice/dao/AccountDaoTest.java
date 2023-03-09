package com.chinchinne.accountservice.dao;

import com.chinchinne.accountservice.annotation.AccountTest;
import com.chinchinne.accountservice.model.AccountDto;
import com.chinchinne.accountservice.vo.RequestParam;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@AccountTest
public class AccountDaoTest
{
    @Autowired
    AccountDao accountDao;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void connectionTest()
    {
        Connection con = sqlSessionFactory.openSession().getConnection();

        assertNotNull(con);
    }

    @Test
    public void accoutDaoTest()
    {
        RequestParam req = RequestParam.builder().userId("967d6988-a1f0-11ed-a8fc-0242ac120002").year("2023").month("3").build();

        List<AccountDto> accounts = accountDao.getAccountByRequestParam(req);

        accounts.stream().forEach( at -> System.out.println( at.toString() ));
    }
}
