package com.nigel.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.print(getClass() + ": ADDING AN ACCOUNT\n");
    }

}
