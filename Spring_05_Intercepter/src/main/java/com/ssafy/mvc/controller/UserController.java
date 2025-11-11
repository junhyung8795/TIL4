package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.service.annotation.GetExchange;

import com.ssafy.mvc.model.User;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		//User라고하는 객체를 하나 만들어서 관리하면 아주 쉽게 처리가 가능하다.
		//넘겨받은 User를 이용해서 실제로 우리의 회원인지를 체크 후 -> Service호출 -> DAO호출 -> DB
		
		//지금 로그인이 되었다! 검증 끝이라고 가정
		//세션에 저장을 하겠다.
		session.setAttribute("loginUser", user.getId());
		return "redirect:hello";
		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		//로그아웃을하려면..
		//1. 속성 지우기(로그이ㅏㄴ 정보)
		session.removeAttribute("loginUser");
		//2.아니면? 세션을 초기화해주자/
		session.invalidate();
		
		return "redirect:hello";
	}
}
