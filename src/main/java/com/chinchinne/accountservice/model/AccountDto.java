package com.chinchinne.accountservice.model;

import com.chinchinne.accountservice.domain.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto
{
    private String year;
    private String month;
    private String day;
    private String category;
    private Status status;
    private String memo;
    private BigInteger amount;
    private BigInteger incomeTotal;
    private BigInteger expenseTotal;
}
