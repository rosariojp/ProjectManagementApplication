package com.jeipz.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeipz.pma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

	@Override
	public List<UserAccount> findAll(); 
	
}
