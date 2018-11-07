package com.example.demo.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtils {
	
	/*
	 * 添加cookies
	 */
	public void setCookies(HttpServletRequest requst,HttpServletResponse response) throws IOException {

        // 1.创建Cookie对象
		Cookie cookies = new Cookie("webname", "XCoder Studio");

        // 2.配置Cookie对象
		cookies.setComment("Web Host Name"); // Cookie描述
		cookies.setMaxAge(24*60*60);         // Cookie有效时间
		//cookie1.setPath("/");              // Cookie有效路径
		
		// 3.通过response对象将Cookie写入浏览器，当然需要解决中文乱码问题，否则会抛出异常
		// java.lang.IllegalArgumentException: Control character in cookie value, consider BASE64 encoding your value
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.addCookie(cookies);
		 // 跳转到首页
//        response.sendRedirect("./index.jsp");
	}
	
	/*
	 * 获取cookies
	 */
	public void getCookies(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    // 读取Cookie，通过request请求读取Cookie
		Cookie[] cookies = request.getCookies();

	    // 判断是否存在Cookie，不存在跳转到首页
		if(cookies == null) {
			response.sendRedirect("./index.jsp");
	        return;
		}

	    // 处理输出中文乱码问题
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取输出对象
		PrintWriter out = response.getWriter();
		// 迭代处理客户端发送来的Cookie对象
		for(Cookie cookie:cookies) {
			System.out.println("Cookie名   称："+cookie.getName());
			System.out.println("Cookie储   值："+cookie.getValue());
			System.out.println("Cookie备   注："+cookie.getComment());
			System.out.println("Cookie有效时间："+cookie.getMaxAge());
			System.out.println("Cookie有效路径："+cookie.getPath());
			System.out.println("Cookie有效域名："+cookie.getDomain());
			
		}
	}
	
	/*
	 * 删除cookies
	 */
	public void delCookies(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// 获取GET传递参数名称
		String delName = request.getParameter("name");
		
		if(delName == null) {
			response.sendRedirect("./CookieRead");
	        return;
		}
		
		// 获取Cookies数组
		Cookie[] cookies = request.getCookies();
		// 迭代查找并清除Cooki
		for(Cookie cookie:cookies) {
			if(delName.equals(cookie.getName())) {
				cookie.setMaxAge(0);
	            response.addCookie(cookie);
			}
		}
		response.setHeader("refresh", "3;./CookieRead");
		PrintWriter out = response.getWriter();
	    out.println("Will go back after 3 seconds...");
	}
}
