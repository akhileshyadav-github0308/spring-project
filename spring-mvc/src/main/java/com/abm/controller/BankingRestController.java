package com.abm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abm.entity.Account;
import com.abm.service.BankingService;

@RestController
public class BankingRestController {
	
	@Autowired
	private BankingService bankingService;
	
	
	@RequestMapping("/getaccdetails")
	public Account getAccountDetails(@RequestParam("accno") int accno){
		System.out.println("Inside getAccountDetails");
		Account account = bankingService.getTransactions(accno);
		return account;
	}
	
	

}
