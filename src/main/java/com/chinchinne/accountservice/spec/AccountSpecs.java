package com.chinchinne.accountservice.spec;

import com.chinchinne.accountservice.domain.entity.Account;
import com.chinchinne.accountservice.domain.model.Common;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigInteger;

public class AccountSpecs
{
    public static Specification<Account> AccountId(BigInteger accountId)
    {;
        return (root, query, builder) -> builder.equal(root.get("accountId"), accountId);
    }

    public static Specification<Account> DelYn(Common delYn)
    {
        return (root, query, builder) -> builder.equal(root.get("delYn"), delYn);
    }

}

