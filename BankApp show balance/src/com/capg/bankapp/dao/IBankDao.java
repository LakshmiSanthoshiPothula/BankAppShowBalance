package com.capg.bankapp.dao;

import com.capg.bankapp.bean.Account;
import com.capg.bankapp.exception.AccountException;

public interface IBankDao {
	public boolean createAccount(Account a);
    public double showBalance(String phoneNumber) throws AccountException;
}
