package com.ssafy.day08.dto;

public class Blog {
	private int id;
	private String title;
	private String authorName;
	private String state;
	private boolean featured;
	
	public Blog() {}

	public Blog(int id, String title, String authorName, String state, boolean featured) {
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.state = state;
		this.featured = featured;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", authorName=" + authorName + ", state=" + state + ", featured="
				+ featured + "]";
	}
	
	
}
