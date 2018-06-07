package com.example.demo.mapper;

import com.example.demo.dao.User;
import com.example.demo.utils.MyMapper;

public interface UserMapper extends MyMapper<User> {
	
	User getUserByMobile(String mobile);
	
	boolean insertUser(String mobile,String password);
}