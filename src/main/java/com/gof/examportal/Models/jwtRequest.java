package com.gof.examportal.Models;

public class jwtRequest {
	String username;
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public jwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

}
