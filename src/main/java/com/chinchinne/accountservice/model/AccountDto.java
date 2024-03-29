package com.chinchinne.accountservice.model;

import com.chinchinne.accountservice.domain.model.Status;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto
{
    private BigInteger accountId;
    private String userId;
    private String year;
    private String month;
    private String day;
    private String category;
    private String backColor;
    private String textColor;
    private Status status;
    private String memo;
    private BigInteger amount;
    private BigInteger incomeTotal;
    private BigInteger expenseTotal;
}
