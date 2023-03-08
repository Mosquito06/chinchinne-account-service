package com.chinchinne.accountservice;

import com.chinchinne.accountservice.config.CustomizationPort;
import com.chinchinne.accountservice.controller.AccountTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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
