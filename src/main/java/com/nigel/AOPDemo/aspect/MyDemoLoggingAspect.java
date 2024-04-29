package com.nigel.AOPDemo.aspect;

import com.nigel.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


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
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Adding account");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("\n====>>> Executing @Before on method: " + methodSignature);

        // display method arguments

        // get arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through arguments
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {

                // downcast and print Account specific information
                Account theAccount = (Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.nigel.AOPDemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,
                                                 List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n====>>> result is : " + result);

        // post-process the data by converting account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====>>> result is : " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.nigel.AOPDemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint,
            Throwable theExc)
    {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n====>>> The exception is: " + theExc);
    }

    @After("execution(* com.nigel.AOPDemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @After (finally) on method: " + method);
    }

    @Around("execution(* com.nigel.AOPDemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        // print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = null;
        try{
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception exc) {
            // log the exception
            System.out.println(exc.getMessage());

            // give user a custom message
            // result = "Major accident! Problem is being solved";

            // rethrow exception
            throw exc;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

}
