package com.chinchinne.accountservice.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotEmpty
    private String category;

    @NotEmpty
    private String status;

    private String memo;

    @Min(0)
    private BigInteger amount;
}
