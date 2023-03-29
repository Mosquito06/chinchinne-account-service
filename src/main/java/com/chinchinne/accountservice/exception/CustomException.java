package com.chinchinne.accountservice.exception;

import com.chinchinne.accountservice.model.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException
{
    private final ErrorCode errorCode;
}
