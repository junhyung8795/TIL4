package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired//서비스 객체가 필요해서 의존성 주입이 필요함!
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	
	//회원 가입 페이지 요청하는 매핑
	@GetMapping("/signup")
	public String signupForm() {
		return "/user/signupform";
	}
	
	
	//회원가입하기위해 정보 POST로 전달
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		userService.signup(user);
		//회원가입 후에 생각나는 시나리오
		//1. 메인페이지로 돌아감. 
		//2. 로그인페이지로 돌아감.
		//3. 회원가입 성공 시 바로 로그인했다 처리하고 메인페이지로 이동
		
		System.out.println("user = " + user);
		return "redirect:login";
	}
	
	//로그인페이지 요청
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	
	
	//로그인 요청
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		//ID/PW
		User loginUser = userService.login(user.getId(), user.getPassword());
		if(loginUser == null) {
			//로그인실패하는 케이스 -> 로그인페이지에 머물러 있어라
			return "redirect:login";
		}
		
		//로그인 성공
		session.setAttribute("loginUser", loginUser);
		return "redirect:list";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/adminPage";
	}
	
	
	
	
	
	
	
}
