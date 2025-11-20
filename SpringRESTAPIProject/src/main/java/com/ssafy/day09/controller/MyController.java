package com.ssafy.day09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	//일반적인 컨트롤러 일때에
	//hello라는 이름의 뷰를 찾는 과정이 일어난다.
	@RequestMapping("/test1")
	public String test1() {
		return "hello";
	}
}
