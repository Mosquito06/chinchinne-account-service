package com.chinchinne.accountservice;

import com.chinchinne.accountservice.annotation.AccountTest;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
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

    @Autowired
    MongoClient mongoClient;

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

    @Test
    void MongoDbConnectionTest()
    {
        MongoDatabase chinchinne = mongoClient.getDatabase("chinchinne");
        assertNotNull(chinchinne);
    }
}
