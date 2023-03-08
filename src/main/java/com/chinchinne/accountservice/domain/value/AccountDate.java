package com.chinchinne.accountservice.domain.value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.Year;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AccountDate
{
    @Column(name = "YEAR")
    private String Year;

    @Column(name = "MONTH")
    private String Month;

    @Column(name = "DAY")
    private String Day;
}
