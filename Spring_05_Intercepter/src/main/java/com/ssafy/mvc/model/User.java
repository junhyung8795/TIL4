package com.ssafy.mvc.model;

public class User {
	private String password;
	private String id;
	public User(String password, String id) {
		super();
		this.password = password;
		this.id = id;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [password=" + password + ", id=" + id + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
