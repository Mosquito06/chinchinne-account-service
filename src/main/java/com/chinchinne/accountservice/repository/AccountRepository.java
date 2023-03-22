package com.chinchinne.accountservice.repository;

import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.value.UserId;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends Repository<Account, BigInteger>
{
    Optional<List<Account>> findByUserId(UserId userId);
    void save(Account account);
}
