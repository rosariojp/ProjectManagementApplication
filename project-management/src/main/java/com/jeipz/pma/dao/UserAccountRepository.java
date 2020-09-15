package com.jeipz.pma.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jeipz.pma.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

	@Override
	public List<UserAccount> findAll(); 
	
}
