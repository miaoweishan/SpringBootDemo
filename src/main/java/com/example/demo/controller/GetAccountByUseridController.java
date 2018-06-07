package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("account")
public class GetAccountByUseridController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("getaccbyuserid")
	public List<Account> queryAccountByUserid(String realname) {
//		System.out.println("realname:  "+realname);
		return accountService.getaccountbyuserid(realname);
		
	}
	

}
