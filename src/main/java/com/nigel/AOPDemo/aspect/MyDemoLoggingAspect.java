package com.nigel.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // advices for logging

    // @Before advice

    // @Before("execution(public void com.nigel.AOPDemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

}
