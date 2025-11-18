package com.ssafy.day08.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.day08.dto.Blog;
import com.ssafy.day08.dto.SearchCondition;

public interface TestDao {
	public List<Blog> selectBlogByTitle(String title);
	public List<Blog> selectBlogByAuthorName(String authorName);
//	public List<Blog> selectBlogByTitleAndAuthorName(SearchCondition condition);// 검색 조건 객체를 생성해 주입!
	public List<Blog> selectBlogByTitleAndAuthorName(Map<String, Object> map);//검색 조건을 따로만들게 아니라면 맵에다가 검색 조건 넣어놓고 맵 자체를 주입!
	public List<Blog> selectBlogByTitleOrAuthorName(String title, String authorName);
}
