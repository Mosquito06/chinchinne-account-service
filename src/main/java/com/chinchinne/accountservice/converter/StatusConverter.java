package com.chinchinne.accountservice.converter;

import com.chinchinne.accountservice.domain.model.Status;

import javax.persistence.Converter;


@Converter( autoApply = true )
public class StatusConverter extends CodeValueConverter<Status>
{
    public StatusConverter()
    {
        super(Status.class);
    }
}
