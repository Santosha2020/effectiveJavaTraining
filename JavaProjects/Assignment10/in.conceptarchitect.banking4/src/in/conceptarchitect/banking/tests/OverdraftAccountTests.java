package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;
import in.conceptarchitect.banking.OverDraftAccount;

public class OverdraftAccountTests {
	double amount=10000;
	String name="Vivek";
	String password="password";
	int minBalance=5000;
	OverDraftAccount account;
	
	@Before
	public void init() {
		
		 account=new OverDraftAccount(name,password,amount);
		
	}


	@Test
	public void account_hasOdLimitAs10PercentOfInitialDeposit() {
		account.deposit(amount);
		account.creditInterest(10);
		//assertEquals(updatedBalance, account.getBalance(),0.2); 
	}
	
	@Test
	public void odLimit_increasesOdLimitIfBalanceIncreasesToHistoricHightestValue() {
		fail("Implement the logic here");
	}
	
	@Test
	public void odLimit_doesntChangeOnWithdrawal() {
		fail("Implement the logic here");
	}
	
	@Test
	public void odLimit_canIncreaseIfCreditInterestIncreasesAccountBalanceUptoHistoricMax() {
		fail("Implement the logic here");
	}
	
	@Test
	public void odLimit_doesntChangeIfNewBalanceIsLessThanHistoricMaxBalance() {
		fail("Implement the logic here");
	}
	
		
	@Test
	public void withdraw_canWithdrawUptoBalancePlusOdLimit() {
		fail("Implement the logic here");
	}

	@Test
	public void withdraw_canPushMyBalanceToNegative() {
		 boolean result=account.withdraw(1000, "p@ss");
		  assertFalse(result);
	}
	
	@Test
	public void withdraw_overlimitAttracts1PCOdFee() {
		fail("Implement the logic here");
	}
	
	
	
	
	
	
}
