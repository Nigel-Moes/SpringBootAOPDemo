package com.nigel.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addMember() {
        System.out.print(getClass() + ": ADDING A MEMBERSHIP ACCOUNT\n");
        return true;
    }

}
