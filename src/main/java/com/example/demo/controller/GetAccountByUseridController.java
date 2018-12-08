package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Account;
import com.example.demo.service.AccountService;
import com.example.demo.utils.CookiesUtils;

@RestController
@RequestMapping("account")
public class GetAccountByUseridController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("getaccbyuserid")
	public List<Account> queryAccountByUserid(HttpServletRequest request,
			String realname) {
//		System.out.println("realname:  "+realname);
//		try {
//			CookiesUtils.setCookies(request, response);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return accountService.getaccountbyuserid(realname);
		
	}
	

}
