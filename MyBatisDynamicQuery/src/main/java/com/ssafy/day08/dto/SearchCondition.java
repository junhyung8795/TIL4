package com.ssafy.day08.dto;

public class SearchCondition {
	private String title;
	private String authorName;
	
	public SearchCondition() {
		// TODO Auto-generated constructor stub
	}

	public SearchCondition(String title, String authorName) {
		this.title = title;
		this.authorName = authorName;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
