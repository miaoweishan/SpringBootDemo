package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.Account;

public interface AccountService {
	/*
	 * 通过手机号查询用户账户信息
	 */
	List<Account> getaccountbyuserid(String realname);
	
}
