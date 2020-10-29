package in.conceptarchitect.banking.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.exceptions.InvalidAccountNumberException;

public class HashMapAccountRepositary {
	
	public final int MAX_ACCOUNTS=10; //PROBLEM: we can't have more than this much account

	//BankAccount [] accounts=new BankAccount[MAX_ACCOUNTS];
	//ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	HashMap <Integer,BankAccount> accounts=new HashMap<Integer,BankAccount>();
	private int accountCount=0;
	
	public int addAccount(BankAccount account) {
		//add the account to account list		
		//account number x will be stored on location x
		//we will never use index 0 to store a account
		account=getAllAccounts().get(account.getAccountNumber());  //add all accounts to the same collection
		accountCount++;
		//return the account Number
		return account.getAccountNumber();
	}
	
	public BankAccount getAccountById(int accountNumber) {
		if(accountNumber<1 || accountNumber>accountCount || getAllAccounts().get(accountNumber)==null)
			//return null; //no such account
			throw new InvalidAccountNumberException(accountNumber);
		
		BankAccount account=getAllAccounts().get(accountNumber);
		return account;
	}
	
	public void removeAccount(int accountNumber) {
		getAllAccounts().remove(accountNumber); //remove the account
	}
	
	public HashMap<Integer, BankAccount> getAllAccounts() {
		return accounts;
	}
	
	

}
