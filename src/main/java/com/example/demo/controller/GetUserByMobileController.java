package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class GetUserByMobileController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("getuserbymobile")
	public User queryUserByMobile(String mobile) {		
		return userService.getUserByMobile(mobile);
		
	}
	
	@PostMapping("adduser")
	public boolean addUser(String mobile,String password){	
		return userService.insertUser(mobile, password);
		
	}
}
