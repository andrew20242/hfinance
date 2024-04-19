package com.reddit.hfs.hfinance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddit.hfs.hfinance.dto.AccountDto;
import com.reddit.hfs.hfinance.entity.Account;
import com.reddit.hfs.hfinance.service.AccountService;
import com.reddit.hfs.hfinance.service.exception.AccountException;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AccountCtrl {

	AccountService accountService;
	
	AccountCtrl(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//Full list of accounts
	@GetMapping("/accounts")
	public List<Account> all() {
		return accountService.getAll();
	}
	
	//Create account
	@PostMapping("/accounts")
	public ResponseEntity<Account> createAccount(
		@RequestBody AccountDto accountDto
	) {
		try {
			Account account = new Account(accountDto.getName(), accountDto.getType());
			Account accountCreated = accountService.createOne(account);
			return new ResponseEntity<>(accountCreated, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Read one account
	@GetMapping("/accounts/{id}")
	public ResponseEntity<AccountDto> getAccount(
		@PathVariable Long id
	) {
		try {
			Account acc = accountService.getOne(id);
			return new ResponseEntity<>(new AccountDto(acc.getName(), acc.getType()), HttpStatus.OK);
		} catch (AccountException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Update one account
	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> updateAccount(
		@PathVariable Long id,
		@RequestBody AccountDto accountDto
	) {
		try {
			Account accountNew = new Account();
			accountNew.setId(id);
			accountNew.setName(accountDto.getName());
			accountNew.setType(accountDto.getType());
			Account acc = accountService.updateOne(accountNew);
			return new ResponseEntity<>(acc, HttpStatus.OK);
		} catch (AccountException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(
		@PathVariable Long id
	) {
		accountService.deleteOne(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
