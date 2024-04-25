package com.nigel.AOPDemo.dao;

import com.nigel.AOPDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, boolean flag) {
        System.out.print(getClass() + ": ADDING AN ACCOUNT\n");
    }

    @Override
    public boolean doWork() {
        System.out.print(getClass() + ": doWork method\n");
        return false;
    }

}
