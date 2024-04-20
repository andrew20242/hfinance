package com.reddit.hfs.hfinance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.reddit.hfs.hfinance.entity.Account;
import com.reddit.hfs.hfinance.repository.AccountRepository;

@Configuration
public class Config {
	//private static final Logger log = LoggerFactory.getLogger(Config.class);
	
	@Bean
	CommandLineRunner initDatabase( AccountRepository accountRepository) {
		
		CommandLineRunner cr = 
			args -> {
				/*
				accountRepository.save(new Account("Freelance","income"));
				accountRepository.save(new Account("Food","outcome"));
				accountRepository.save(new Account("bank card A","both"));
				accountRepository.save(new Account("bank card B","both"));
				accountRepository.save(new Account("Sport","outcome"));
				
				accountRepository.findAll().stream().forEach(a->log.info("init: " + a.toString()));
				*/
			};
		return cr;
	}
}
