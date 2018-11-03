package com.capg.bankapp.service;

import com.capg.bankapp.bean.Account;
import com.capg.bankapp.dao.BankDao;
import com.capg.bankapp.dao.IBankDao;
import com.capg.bankapp.exception.AccountException;
import com.capg.bankapp.exception.AccountExceptionMessages;

public class BankService implements IBankService {
	IBankDao dao = new BankDao();

	@Override
	public boolean createAccount(Account account) {
		// TODO Auto-generated method stub
		return dao.createAccount(account);
	}

	@Override
	public double showBalance(String phoneNumber) throws AccountException {
		// TODO Auto-generated method stub
		return dao.showBalance(phoneNumber);
	}

	public boolean validPhoneNumber(Account account) throws AccountException {

		boolean valid = true;

		if (!(account.getPhoneNumber().length()==10)) {
			throw new AccountException(AccountExceptionMessages.ERROR2);
		}

		if (account.getPhoneNumber().equals(null) ){
			throw new AccountException(AccountExceptionMessages.ERROR3);
		}
		if( !(account.getPhoneNumber().matches("[7-9][0-9]{9}"))){
			throw new AccountException(AccountExceptionMessages.ERROR4);
		}
		return valid;
	}
}
