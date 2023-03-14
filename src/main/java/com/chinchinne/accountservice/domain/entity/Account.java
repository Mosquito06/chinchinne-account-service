package com.chinchinne.accountservice.domain.entity;

import com.chinchinne.accountservice.domain.model.Common;
import com.chinchinne.accountservice.domain.model.Status;
import com.chinchinne.accountservice.domain.value.AccountDate;
import com.chinchinne.accountservice.domain.value.CategoryId;
import com.chinchinne.accountservice.domain.value.UserId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@Getter
@Access( AccessType.FIELD )
public class Account
{
    @Id
    @Column(name = "SEQ")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private BigInteger accountId;

    @Embedded
    private UserId userId;

    @Embedded
    private AccountDate accountDate;

    @Embedded
    private CategoryId categoryId;

    @Column( name = "STATUS" )
    private Status status;

    @Column( name = "MEMO" )
    private String memo;

    @Column( name = "AMOUNT" )
    private BigInteger amount;

    @Column( name = "REG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column( name = "MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;

    @Embedded
    @AttributeOverrides
    (
        @AttributeOverride( name = "id", column = @Column( name = "MOD_ID"))
    )
    private UserId modId;

    @Column( name = "DEL_YN")
    private Common delYn;
}
