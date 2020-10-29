package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.SavingsAccount;
import static in.conceptarchitect.utils.CustomAsserts.*;

public class BankTests {
	
	String name="Vivek";
	String correctPassword="password";
	double balance=20000;
	int sourceAccountNumber=5;
	int targetAccountNumber=7;
	 Bank bank;
	 BankAccount account;
	 
	 @Before  
	public void init() {
		 bank=new Bank(name,balance);
		 BankAccount account=new BankAccount(name,correctPassword, balance);
		}
	 
	@Test
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		boolean result=bank.transfer(sourceAccountNumber, balance, correctPassword, 11);
		assertEquals(false, result);
	}
	
	@Test
	public void transfer_shouldFailIfInvalidToAccount() {
		boolean result=bank.transfer(sourceAccountNumber, balance, correctPassword, 11);
		assertFalse(result);
	}
	
	@Test
	public void transfer_shouldFailForInvalidPassword() {
		boolean result=bank.transfer(sourceAccountNumber, balance, "p@ss", targetAccountNumber);
		assertFalse(result);
	}
	
	@Test
	public void transfer_shouldFailForInsufficientBalance() {
		boolean result=bank.transfer(sourceAccountNumber, 30000, correctPassword, targetAccountNumber);
		assertFalse(result);
	}
	
	@Test
	public void transfer_shouldSucceedInHappyPath() {
		boolean result=bank.transfer(sourceAccountNumber, 3000, correctPassword, targetAccountNumber);
		assertTrue(result);
	}
	
	@Test
	public void creditInterest_creditsOneMonthOfInterest() {
		bank.creditInterests();
		double updatedBalance= balance+ balance*12/1200;
		assertEquals(updatedBalance, account.getBalance(),0.2);
	}
	
	@Test
	public void closeAccount_failsForInvalidAccountNumber() {
		boolean result=bank.close(11,correctPassword );
		assertFalse(result);
	}
	
	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() {
		boolean result=bank.close(11,correctPassword );
		assertFalse(result);
	}
	
	@Test
	public void openAccount_withSavingsTypeCreatesASavingAccount() {
		
		Bank bank=new Bank("bank name",1);
		
		bank.openAccount("savings", "someone", "somepassword", 1000);
		
		BankAccount account=bank.getAccount(1,"somepassword");
		
		assertType(SavingsAccount.class, account);
		
	}
	
	
	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
	
	}
	

}
