package com.chinchinne.accountservice.domain.model;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status implements CodeValue
{
     INCOME("I", "수입")
    ,EXPENSE("O", "지출");

    private String code;
    private String value;

    @Override
    public String getCode()
    {
        return this.code;
    }

    @Override
    public String getValue()
    {
        return this.value;
    }
}
