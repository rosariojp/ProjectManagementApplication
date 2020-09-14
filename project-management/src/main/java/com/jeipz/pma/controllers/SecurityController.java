package com.jeipz.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jeipz.pma.entities.UserAccount;
import com.jeipz.pma.services.UserAccountService;

@Controller
public class SecurityController {

	@Autowired
	UserAccountService userAccountService;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount", userAccount);
		return "security/register";
	}

	@PostMapping("/register/save")
	public String saveUser(Model model, UserAccount user) {
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		userAccountService.save(user);
		return "redirect:/login";
	}
	
}
