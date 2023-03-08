package com.chinchinne.accountservice.controller;

import com.chinchinne.accountservice.AccountServiceApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootTest
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
@TestPropertySource(locations="classpath:/application.yml")
@ContextConfiguration( classes = AccountServiceApplication.class)
@Transactional
public @interface AccountTest
{

}
