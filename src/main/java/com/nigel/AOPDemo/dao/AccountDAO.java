package com.nigel.AOPDemo.dao;

import com.nigel.AOPDemo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();

    void addAccount(Account theAccount, boolean flag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
