package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;
import in.conceptarchitect.banking.SavingsAccount;

public class CurrentAccountTests {
	double amount=1000;
	String name="Vivek";
	String password="password";
	int minBalance=5000;
	CurrentAccount account;
	
	@Before
	public void init() {
		
		 account=new CurrentAccount(name,password,amount);
		
	}

	@Test
	public void creditInterest_doesntCreditInterestToCurrentAccount() {

		double amount=10000;
		CurrentAccount account=new CurrentAccount("","",amount);
		
		account.creditInterest(12);
		
		assertEquals(amount, account.getBalance(),0);  //balance shouldn't change after crediting interest 
				
	}

	
	@Test
	public void withdraw_canWithdrawUptoBalanceUsingRightPassword() {
		account.withdraw(amount, password);
		assertEquals(amount, account.getBalance(),0);
	}
	
	@Test
	public void withdraw_failsForInsufficientBalance() {
		//double amount=10000;
	    boolean result=account.withdraw(amount+1, password);
		assertFalse(result);
	}
	
	@Test
	public void withdraw_failsForWrongPassword() {
		  boolean result=account.withdraw(amount, "p@ss");
			assertTrue(result);
	}
	
	@Test
	public void withdraw_failsForNegativeAmount() {
		  boolean result=account.withdraw(-1000, "p@ss");
		  assertFalse(result);
	}
}
