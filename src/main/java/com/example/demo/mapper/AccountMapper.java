package com.example.demo.mapper;

import java.util.List;

import com.example.demo.dao.Account;
import com.example.demo.utils.MyMapper;

public interface AccountMapper extends MyMapper<Account> {
	/*
	 * 通过手机号查询用户账户信息
	 */
	List<Account> getaccountbyuserid(String realname);
}