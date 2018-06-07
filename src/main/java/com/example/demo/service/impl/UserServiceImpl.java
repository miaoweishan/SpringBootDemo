package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public User getUserByMobile(String mobile) {
		if("".equals(mobile.trim()) || mobile == null) {
			throw new RuntimeException("请输入手机号！");
		}else if(mobile.length() !=11) {
			throw new RuntimeException("请输入合法的手机号！");
		}else {
			return userMapper.getUserByMobile(mobile);
		}
				
	}

	@Override
	public boolean insertUser(String mobile, String password) {
		
		if(userMapper.getUserByMobile(mobile)!=null ) {
			throw new RuntimeException("该手机号已经注册过！");
		}else if(mobile==null || "".equals(mobile) || !mobile.matches("^1\\d{10}$")){
			throw new RuntimeException("请输入合法的手机号！");
		}else if(password == null || "".equals(password)) {
			throw new RuntimeException("输入的密码为空！");
		}else {
			return userMapper.insertUser(mobile, password);
		}
			
	}

}
