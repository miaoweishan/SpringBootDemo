package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public List<Account> getaccountbyuserid(String realname) {
		System.out.println("realname:  "+realname);
		if(realname==null || "".equals(realname.trim())) {
			throw new RuntimeException("用户姓名不可为空！");
		}else {
			
			return accountMapper.getaccountbyuserid(realname);
		}
		
	}

}
