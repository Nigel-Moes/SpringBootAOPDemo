package com.nigel.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // advices for logging

    // @Before advice

    // @Before("execution(public void com.nigel.AOPDemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(* add*(com.nigel.AOPDemo.Account, ..))")
    // @Before("execution(* add*(..))")
    // @Before("execution(* com.nigel.AOPDemo.dao.*.*(..))")

    @Pointcut("execution(* com.nigel.AOPDemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
