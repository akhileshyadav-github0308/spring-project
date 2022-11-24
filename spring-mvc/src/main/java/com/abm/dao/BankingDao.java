package com.abm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.abm.entity.Account;
import com.abm.entity.Transaction;

@Component
// @Repository  (recommended)
public class BankingDao {

	@PersistenceContext
	private EntityManager entityManager;

//	@Transactional
	public int add(Account account) {
//		entityManager.persist(account);
		//System.out.println(account);
		//entityManager.persist(account);
		System.out.println(account);
		
		Account merge = entityManager.merge(account);
		
		System.out.println("merge : "+merge);
		
		// another way to update accNo set generaeted accNo to Account account this is example of call by reference
		
		return merge.getAccNo();
		
	}
	
//	@Transactional
	public int add(Transaction t) {
	     Transaction transaction = entityManager.merge(t);
	     return transaction.getTxnNo();
	}
	
//	@Transactional
	public Account uppdate(Account acc) {
		   Account account = entityManager.merge(acc);
		   return account;
	}

	public Account fetch(int acc) {
		return entityManager.find(Account.class, acc);
	}
	
	public List<Transaction> getTransactions(int accNo){
		System.out.println("Banking Dao getTransactions 1");
		List<Transaction> resultList = entityManager.createQuery("select tx from Transaction tx where tx.account.accNo= :accno",Transaction.class)
		.setParameter("accno", accNo)
		.getResultList();
		System.out.println("Banking Dao getTransactions 2");
		return resultList;
	}
	
	public Account fetchAccount(int accno) {
		return	 entityManager
				.createQuery("select distinct a from Account a join fetch a.transactions where a.id= :id",Account.class)
		        .setParameter("id", accno)
		        .getSingleResult();
	}
}
