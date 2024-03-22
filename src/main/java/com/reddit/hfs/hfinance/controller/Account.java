package com.reddit.hfs.hfinance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Account {

	@GetMapping("/accounts")
	String all() {
		return "test";
	}
}
