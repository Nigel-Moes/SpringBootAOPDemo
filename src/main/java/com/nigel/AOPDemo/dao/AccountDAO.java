package com.nigel.AOPDemo.dao;

import com.nigel.AOPDemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean flag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
