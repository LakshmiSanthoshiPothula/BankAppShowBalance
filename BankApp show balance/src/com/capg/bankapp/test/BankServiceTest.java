package com.capg.bankapp.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.bankapp.bean.Account;
import com.capg.bankapp.exception.AccountException;
import com.capg.bankapp.service.BankService;
import com.capg.bankapp.service.IBankService;

public class BankServiceTest {

	private static IBankService service = null;

	@BeforeClass
	public static void createInstance() {
		service = new BankService();
	}
    
	
	@Test
	public void testShowBalance() throws AccountException {

		Account a = new Account();
        a.setPhoneNumber("9988776655");
		a.setBalance(25000.00);
		service.createAccount(a);
		double balance = service.showBalance("9988776655");
		System.out.println("***BALANCE IN YOUR ACCOUNT***\n"+balance);
		assertTrue(balance==25000.00);
		
	
	}
	

	@Test
	public void test() throws AccountException{
		Account account=new Account();
	    account.setPhoneNumber("9655999994");
        account.setBalance(25000.0);
        boolean result=service.validPhoneNumber(account);
        assertTrue(result);
        
	}
	
	@Test(expected=AccountException.class)
	public void testForTenDigits() throws AccountException{
		Account account=new Account();
	    account.setPhoneNumber("989999");
        account.setBalance(25000.0);
        boolean result=service.validPhoneNumber(account);
        assertFalse(result);
        
        
	}
	
	@Test(expected=Exception.class)
	public void testForNotNull() throws NullPointerException,AccountException{
		Account account=new Account();
	    account.setPhoneNumber(null);
        account.setBalance(25000.0);
        boolean result=service.validPhoneNumber(account);
        assertFalse(result);
        
        
	}
	
	@Test(expected=AccountException.class)
	public void testForPattern() throws AccountException{
		Account account=new Account();
	    account.setPhoneNumber("00889966");
        account.setBalance(25000.0);
        boolean result=service.validPhoneNumber(account);
        assertFalse(result);
        
        
	}
	
	
	
}
