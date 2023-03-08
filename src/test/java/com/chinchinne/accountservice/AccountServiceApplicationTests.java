package com.chinchinne.accountservice;

import com.chinchinne.accountservice.annotation.AccountTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@AccountTest
class AccountServiceApplicationTests
{
    @Autowired
    DataSource dataSource;

    @Test
    void DBConnectionTest()
    {
        try
        {
            Connection con = dataSource.getConnection();
            assertNotNull(con);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
