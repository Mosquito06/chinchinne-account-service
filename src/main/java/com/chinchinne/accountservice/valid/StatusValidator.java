package com.chinchinne.accountservice.valid;

import com.chinchinne.accountservice.domain.model.Status;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.engine.jdbc.connections.internal.ConnectionValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Connection;
import java.sql.SQLException;

public class StatusValidator implements ConstraintValidator<StatusValid, String>
{
    private final String[] ALLOW_ARRAY = new String[]{ Status.INCOME.name(), Status.EXPENSE.name() };

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext)
    {
        if (value == null)
        {
            return false;
        }

        if (ArrayUtils.contains(ALLOW_ARRAY, value))
        {
            return true;
        }

        return false;
    }
}
