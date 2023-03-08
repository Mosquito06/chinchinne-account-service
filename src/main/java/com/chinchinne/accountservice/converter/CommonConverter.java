package com.chinchinne.accountservice.converter;

import com.chinchinne.accountservice.domain.model.Common;
import com.chinchinne.accountservice.domain.model.Status;

import javax.persistence.Converter;

@Converter( autoApply = true )
public class CommonConverter extends CodeValueConverter<Common>
{
    public CommonConverter()
    {
        super(Common.class);
    }
}
