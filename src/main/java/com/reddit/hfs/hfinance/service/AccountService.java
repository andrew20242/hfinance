package com.reddit.hfs.hfinance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reddit.hfs.hfinance.dto.AccountDto;
import com.reddit.hfs.hfinance.entity.Account;
import com.reddit.hfs.hfinance.repository.AccountRepository;
import com.reddit.hfs.hfinance.service.exception.AccountException;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public List<Account> getAll() {
		return accountRepository.findAll();
	}
	
	public Account createOne(AccountDto accountDto) {
		Account account = new Account(accountDto.getName(), accountDto.getType());
		Account accountCreated = accountRepository.save(account);
		return accountCreated;
	}
	
	public Account getOne(Long id) throws AccountException {
		Optional<Account> opAccount = accountRepository.findById(id);
		if (opAccount.isPresent()) {
			return opAccount.get();
		} else {
			throw new AccountException();
		}
	}
	
	public void deleteOne(Long id) {
		accountRepository.deleteById(id);
	}
	
	public Account updateOne(Account accountNew) throws AccountException {
		Optional<Account> accountData = accountRepository.findById(accountNew.getId());
		if (accountData.isPresent()) {
			Account accountCur = accountData.get();
			if (accountNew.getName() != null) accountCur.setName(accountNew.getName());
			if (accountNew.getType() != null) accountCur.setType(accountNew.getType());
			return accountRepository.save(accountCur);
		} else {
			throw new AccountException();
		}
	}
}
