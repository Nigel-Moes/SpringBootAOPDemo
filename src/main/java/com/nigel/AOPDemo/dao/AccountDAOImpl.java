package com.nigel.AOPDemo.dao;

import com.nigel.AOPDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String ServiceCode;

    @Override
    public void addAccount(Account theAccount, boolean flag) {
        System.out.print(getClass() + ": addAccount method\n");
    }

    @Override
    public boolean doWork() {
        System.out.print(getClass() + ": doWork method\n");
        return false;
    }

    public String getName() {
        System.out.print(getClass() + ": getName method \n");
        return name;
    }

    public void setName(String name) {
        System.out.print(getClass() + ": setName method \n");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.print(getClass() + ": getServiceCode method\n");
        return ServiceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.print(getClass() + ": setServiceCode method\n");
        ServiceCode = serviceCode;
    }
}
