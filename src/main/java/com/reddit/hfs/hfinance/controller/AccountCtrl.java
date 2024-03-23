package com.reddit.hfs.hfinance.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.hfs.hfinance.entity.Account;
import com.reddit.hfs.hfinance.repository.AccountRepository;

@RestController
public class AccountCtrl {

	private final AccountRepository accountRepository;
	
	AccountCtrl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@GetMapping("/accounts")
	List<Account> all() {
		return accountRepository.findAll();
	}
	

}
