package com.example.demo.service;

import com.example.demo.dao.User;

public interface UserService {
	/*
	 * 通过 mobile 查询用户信息
	 */
	User getUserByMobile(String mobile);
	
	/*
	 * 用户注册
	 */
	boolean insertUser(String mobile,String password);

}
