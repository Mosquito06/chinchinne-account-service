package com.chinchinne.accountservice.domain.value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class AccountId implements Serializable
{
    @Column(name = "SEQ")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private BigInteger id;
}
