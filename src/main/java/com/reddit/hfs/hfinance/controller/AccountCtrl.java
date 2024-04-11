package com.reddit.hfs.hfinance.controller;

import java.util.List;
import java.util.Optional;

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

import com.reddit.hfs.hfinance.entity.Account;
import com.reddit.hfs.hfinance.repository.AccountRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AccountCtrl {

	private final AccountRepository accountRepository;
	
	AccountCtrl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	//Full list of accounts
	@GetMapping("/accounts")
	public List<Account> all() {
		return accountRepository.findAll();
	}
	
	//Create account
	@PostMapping("/accounts")
	public ResponseEntity<Account> createAccount(
		@RequestBody Account account
	) {
		try {
			Account accountCreate = accountRepository.save(
				new Account(account.getName(), account.getType()));
			return new ResponseEntity<>(accountCreate, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Read one account
	@GetMapping("/accounts/{id}")
	public Optional<Account> getAccount(
		@PathVariable Long id
	) {
		return accountRepository.findById(id);
	}
	
	//Update one account
	@PutMapping("/accounts")
	public ResponseEntity<Account> updateAccount(
		@RequestBody Account accountNew
	) {
		Optional<Account> accountData = accountRepository.findById(accountNew.getId());
		if (accountData.isPresent()) {
			Account accountCur = accountData.get();
			accountCur.setName(accountNew.getName());
			accountCur.setType(accountNew.getType());
			return new ResponseEntity<>(accountRepository.save(accountCur), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(
		@PathVariable Long id
	) {
		accountRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
