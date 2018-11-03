package com.capg.bankapp.dao;

import java.util.ArrayList;

import com.capg.bankapp.bean.Account;
import com.capg.bankapp.exception.AccountException;
import com.capg.bankapp.exception.AccountExceptionMessages;

public class BankDao implements IBankDao {
	private ArrayList<Account> list = new ArrayList<Account>();

	@Override
	public boolean createAccount(Account a) {
		boolean valid = false;

		if (list.add(a))
			valid = true;
		return valid;
	}

	@Override
	public double showBalance(String phoneNumber) throws AccountException {
		double balance = 0;

		for (Account a : list) {
			if (a.getPhoneNumber().equals(phoneNumber)) {

				balance = a.getBalance();

			}
		}
       
		
	    if(balance==0){
	    	throw new AccountException(AccountExceptionMessages.ERROR1);
	    }
		return balance;

	}

}
