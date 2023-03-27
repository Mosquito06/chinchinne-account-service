package com.chinchinne.accountservice.valid;

import com.chinchinne.accountservice.domain.model.Status;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention( RetentionPolicy.RUNTIME )
@Constraint( validatedBy = StatusValidator.class )
public @interface StatusValid
{
    String message() default "올바르지 않은 타입입니다(INCOME or EXPENSE)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
