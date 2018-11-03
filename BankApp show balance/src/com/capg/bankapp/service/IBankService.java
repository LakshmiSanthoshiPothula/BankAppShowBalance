package com.capg.bankapp.service;

import com.capg.bankapp.bean.Account;
import com.capg.bankapp.exception.AccountException;

public interface IBankService {
	public boolean createAccount(Account a);
    public double showBalance(String phoneNumber) throws AccountException;
	public boolean validPhoneNumber(Account account) throws AccountException;
}
