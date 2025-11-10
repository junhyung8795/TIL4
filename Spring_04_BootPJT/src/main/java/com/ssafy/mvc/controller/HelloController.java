package com.ssafy.mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	//이때 반환하는 문자열은 뷰의 이름이다!
	public String hello(Model model) {
		model.addAttribute("msg", "Hello Spring Boot");
		return "hello"; //view 이름: /WEB-INF/views/hello.jsp
	}
	
	
	
	
}
