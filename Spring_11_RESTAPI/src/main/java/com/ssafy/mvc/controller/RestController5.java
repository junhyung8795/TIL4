package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.UserDto;

@RestController
@RequestMapping("/rest5")
public class RestController5 {
	// http://localhost:8080/rest5/board1
//	@PostMapping("/user1")
//	public String test1(@ModelAttribute UserDto user) {
//		//입력받은 데이터를 이용해서 서비스를 호출하고등록
//		
//		
//		return user.toString();
//	}
	
	@PostMapping("/user1")
	public UserDto test1(@ModelAttribute UserDto user) {
		//입력받은 데이터를 이용해서 서비스를 호출하고등록
		
		
		return user;
	}
	
	@PostMapping("/user2")
	public UserDto test3(@RequestBody UserDto user) {
		//입력받은 데이터를 이용해서 서비스를 호출하고등록
		
		return user;
	}
}
