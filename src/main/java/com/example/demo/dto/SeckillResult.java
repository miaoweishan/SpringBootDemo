package com.example.demo.dto;
/*
 *封装返回结果
 */
public class SeckillResult<T> {
	private boolean seccess;
	
	private T data;
	
	private String error;
	
	public SeckillResult(boolean status, T data) {
		this.seccess=status;
		this.data=data;
	}
	
	public SeckillResult(boolean status, String error) {
		this.seccess=status;
		this.error=error;
	}

	public boolean isSeccess() {
		return seccess;
	}

	public void setSeccess(boolean seccess) {
		this.seccess = seccess;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
