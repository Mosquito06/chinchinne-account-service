package com.chinchinne.accountservice.repository.mongo;

import com.chinchinne.accountservice.domain.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;


public interface AccountMongoRepository extends MongoRepository<Account, BigInteger>
{
    List<Account> findAll();

    Account save(Account account);
}
