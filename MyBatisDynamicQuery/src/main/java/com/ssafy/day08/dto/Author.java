package com.ssafy.day08.dto;

public class Author {
	private int id;
	private String username;
	private String password;
	private String email;
	private String bio;
	
	public Author() {}
	
	public Author(int id, String username, String password, String email, String bio) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	
	
}
