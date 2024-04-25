package com.nigel.AOPDemo.dao;

import com.nigel.AOPDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String ServiceCode;

    @Override
    public void addAccount(Account theAccount, boolean flag) {
        System.out.print(getClass() + ": ADDING AN ACCOUNT\n");
    }

    @Override
    public boolean doWork() {
        System.out.print(getClass() + ": doWork method\n");
        return false;
    }

    public String getName() {
        System.out.print(getClass() + ": in getName()\n");
        return name;
    }

    public void setName(String name) {
        System.out.print(getClass() + ": in setName()\n");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.print(getClass() + ": in getServiceCode()\n");
        return ServiceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.print(getClass() + ": in setServiceCode()\n");
        ServiceCode = serviceCode;
    }
}
