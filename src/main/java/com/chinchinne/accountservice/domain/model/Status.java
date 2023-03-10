package com.chinchinne.accountservice.domain.model;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status implements CodeValue
{
     INCOME("I", "μμ")
    ,EXPENSE("O", "μ§μΆ");

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
