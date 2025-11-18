package com.ssafy.day08.dto;

public class Post {
	private int ID;
	private String title;
	private String content;
	private int authorId;
	private int blogId;
	
	
	public Post() {
	}


	public Post(int iD, String title, String content, int authorId, int blogId) {
		ID = iD;
		this.title = title;
		this.content = content;
		this.authorId = authorId;
		this.blogId = blogId;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}


	public int getBlogId() {
		return blogId;
	}


	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	
	
}
