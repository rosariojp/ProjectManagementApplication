package com.jeipz.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeipz.pma.dao.UserAccountRepository;
import com.jeipz.pma.entities.UserAccount;

@Service
public class UserAccountService {

	@Autowired
	UserAccountRepository userAccountRepo;
	
	public UserAccount save(UserAccount userAccount) {
		return userAccountRepo.save(userAccount);
	}
	
	public List<UserAccount> getAll() {
		return userAccountRepo.findAll();
	}
	
}
