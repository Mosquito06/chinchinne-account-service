package com.chinchinne.accountservice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class RequestParam
{
    private String userId;
    private String year;
    private String month;
    private String day;
}
