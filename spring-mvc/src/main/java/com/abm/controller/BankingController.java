package com.abm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abm.entity.Account;
import com.abm.service.BankingService;

@Controller
public class BankingController {
	
	@Autowired
	private BankingService bankingService;

	@RequestMapping("/openAccount")
	public String openAccount(Account account, Map<String,Object> model) {
		
		try {
			int accNo = bankingService.openAccount(account);
			System.out.println("accNo : "+accNo);
			model.put("genAccNo", accNo);
			return "confirmation.jsp";
		} catch (Exception e) {
			return "open_account.jsp";
		}
		
	}
	
	@RequestMapping("/transfer")
	public String transfer(@RequestParam("acc1") int fromAcc,@RequestParam("acc2") int toAcc,@RequestParam("amount") int amount, Map<String,Object> model) {
		
		try {
			if(fromAcc==toAcc) {
				System.out.println("You can not transer to your own account");
				model.put("result", "You can not transer to your own account");
				return "confirmation.jsp";
			}
			String result = bankingService.transfer(fromAcc, toAcc, amount);
			model.put("result", result);
			return "confirmation.jsp";
		} catch (Exception e) {
			return "transfer.jsp";
		}
		
	}
	
	@RequestMapping("/getTransactions")
	public String getTransactions(@RequestParam("acc") int accno, Map<String,Account> model) {
		
		try {
			
			Account account = bankingService.getTransactions(accno);
			model.put("account", account);
			System.out.println(account);
			return "transactionConfirmation.jsp";
		} catch (Exception e) {
			return "transaction.jsp";
		}
		
	}

}
