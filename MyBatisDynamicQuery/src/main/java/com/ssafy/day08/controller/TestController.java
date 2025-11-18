package com.ssafy.day08.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.day08.dao.TestDao;
import com.ssafy.day08.dto.Blog;

@Controller
public class TestController {
	@Autowired
	TestDao dao;
	
	@ResponseBody
	@GetMapping("/search")
	public String searchByTitle(@RequestParam String title) {
		List<Blog> blogs = dao.selectBlogByTitle(title);
		return blogs.toString(); // 논리뷰의 이름...!(X) -> 반환하게될 데이터(body)에 전달...(O)
	}
	
	@ResponseBody
	@GetMapping("/search2")
	public List<Blog> searchByTitle2(@RequestParam String title) {
		List<Blog> blogs = dao.selectBlogByTitle(title);
		return blogs; // 논리뷰의 이름...!(X) -> 반환하게될 데이터(body)에 전달...(O)
	}
	
	@ResponseBody
	@GetMapping("/search-author")
	public List<Blog> searchBlogByAuthor(@RequestParam String authorName) {
		List<Blog> blogs = dao.selectBlogByAuthorName(authorName);
		return blogs; // 논리뷰의 이름...!(X) -> 반환하게될 데이터(body)에 전달...(O)
	}
	
	@ResponseBody
	@GetMapping("/search3")
	public List<Blog> searchBlogByTitleAndAuthor(@RequestParam String title, @RequestParam String authorName) {
//		SearchCondition condition = new SearchCondition(title, authorName);
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		map.put("authorName", authorName);
		
		List<Blog> blogs = dao.selectBlogByTitleAndAuthorName(map);
		return blogs; // 논리뷰의 이름...!(X) -> 반환하게될 데이터(body)에 전달...(O)
	}
	
	@ResponseBody
	@GetMapping("/search4")
	public List<Blog> searchBlogsByTitleOrAuthor(@RequestParam(required = false) String title, @RequestParam String authorName) {
		List<Blog> blogs = dao.selectBlogByTitleOrAuthorName(title, authorName);
		return blogs;
	}
}
