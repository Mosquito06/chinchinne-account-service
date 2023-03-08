package com.chinchinne.accountservice.domain.value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CategoryId implements Serializable
{
    @Column(name = "CATEGORY_ID")
    private String id;
}
