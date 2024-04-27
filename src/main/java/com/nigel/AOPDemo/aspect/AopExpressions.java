package com.nigel.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    // general pointcut
    @Pointcut("execution(* com.nigel.AOPDemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // pointcut for the getter methods
    @Pointcut("execution(* com.nigel.AOPDemo.dao.*.get*(..))")
    public void getter() {}

    // pointcut for the setter methods
    @Pointcut("execution(* com.nigel.AOPDemo.dao.*.set*(..))")
    public void setter() {}

    // pointcut: include package, exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter() {}
}
