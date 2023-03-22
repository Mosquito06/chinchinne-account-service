package com.chinchinne.accountservice.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class RequestAccount
{
    private String userId;
    private String year;
    private String month;
    private String day;
    private String category;
    private String status;
    private String memo;
    private BigInteger amount;
}
