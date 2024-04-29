package com.nigel.AOPDemo.dao;

import com.nigel.AOPDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String ServiceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // simulate an exception
        if (tripWire) {
            throw new RuntimeException("Exception in findAccounts");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to the accounts lists
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

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
