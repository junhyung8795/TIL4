package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.UserDto;

@RestController
@RequestMapping("/rest4")
public class RestController4 {
	// http://localhost:8080/rest4/board/1
	// http://localhost:8080/rest4/board/2
	// http://localhost:8080/rest4/board/3
	@GetMapping("/board/{boardId}")
	public String test1(@PathVariable("boardId") int boardId) {
		//서비스에서 id를 가지고 해당 게시글을 보여줌
		return boardId+ "번 게시글";// hello라고 하는 이름의 뷰가 있는지 찾는다. ->restcontroller가 붙어서 데이터를 보내기에 뷰를 안찾음
	}
	
	
	//이렇게하면 "보드 다음의 변수"라는 이 포맷이 test1의 맵핑 주소와 같아져서 404에러가 뜬다.
	@GetMapping("/board/{reviewId}")
	public String test2(@PathVariable("reviewId") int reviewId) {
		//서비스에서 id를 가지고 해당 게시글을 보여줌
		return reviewId+ "번 게시글";// hello라고 하는 이름의 뷰가 있는지 찾는다. ->restcontroller가 붙어서 데이터를 보내기에 뷰를 안찾음
	}

}
