package com.nigel.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // @Before("execution(public void com.nigel.AOPDemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(* add*(com.nigel.AOPDemo.Account, ..))")
    // @Before("execution(* add*(..))")
    // @Before("execution(* com.nigel.AOPDemo.dao.*.*(..))")

    @Before("com.nigel.AOPDemo.aspect.AopExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Adding account");
    }

}
