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

    // create a pointcut for the getter methods
    @Pointcut("execution(* com.nigel.AOPDemo.dao.*.get*(..))")
    private void getter() {}

    // create a pointcut for the setter methods
    @Pointcut("execution(* com.nigel.AOPDemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package, exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter() {}

    @Before("forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDAOPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
