package com.abm.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abm.dao.BankingDao;
import com.abm.entity.Account;
import com.abm.entity.Transaction;
import com.abm.error.BankingException;

@Component
//@Service  (recommended)

@Transactional
public class BankingService {

	@Autowired
	private BankingDao bankingDao;

	public int openAccount(Account account) throws BankingException {
		if (account.getBalance() >= 5000) {
			return bankingDao.add(account);
		} else {
			throw new BankingException("Can not open Account!");
		}
	}
	
	public Account getTransactions(int accNo) {
		Account account= bankingDao.fetch(accNo);
		System.out.println(account);
		List<Transaction> transactions = bankingDao.getTransactions(account.getAccNo());
		System.out.println("getTransactions ");
		if(account.getTransactions()==null) {
			account.setTransactions(transactions);
		}
		
		return account;
		
	}
	
	public String transfer(int fromAcc, int toAcc, int amount) {
		
		Account fromAccount= bankingDao.fetch(fromAcc);
		Account toAccount= bankingDao.fetch(toAcc);
		System.out.println("step 0");
		fromAccount.setBalance(fromAccount.getBalance() -amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		System.out.println("step 1");
		bankingDao.uppdate(fromAccount);
		bankingDao.uppdate(toAccount);
		
		Transaction t1= new Transaction();
		t1.setAccount(fromAccount);
		t1.setType("DEBIT");
		t1.setDateAndTime(LocalDateTime.now());
		t1.setAmoount(amount);
		
		Transaction t2= new Transaction();
		t2.setAccount(toAccount);
		t2.setType("CREDIT");
		t2.setDateAndTime(LocalDateTime.now());
		t2.setAmoount(amount);
		System.out.println("step 2");
		
		int txn1 = bankingDao.add(t1);
		int txn2 = bankingDao.add(t2);
		System.out.println("step 3");
		System.out.println("Transction Ids : "+ txn1+" Cr.  "+ txn2+" Dr.");
		
		return "Transction Ids : "+ txn1+" Cr.  "+ txn2+" Dr.";

		
	}

}
