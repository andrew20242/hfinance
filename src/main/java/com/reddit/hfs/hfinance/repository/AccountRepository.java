package com.reddit.hfs.hfinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reddit.hfs.hfinance.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
