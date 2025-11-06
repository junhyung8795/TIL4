package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ControllerParameter {
	
//	public String test1(HttpServletRequest request) {
//		return null;
//		//request 객체를 쓰고싶어
//	}
	//위와 똑같다. 다만 파라미터 생략가능
	@GetMapping("/test1")
	public String test1() {
		//request 객체를 쓰고싶어
		//String 반환 -> View 이름이라고 생각함.
		return "test1"; //WEB-INF/view아래에  test1.jsp찾음
	}
	
	@GetMapping("/test2-1")
	public String test2_1(Model model) {
		//데이터를 View에 전달하고싶어! Model사용
		//model이라는 바구니를 파라미터로 준비
		model.addAttribute("msg", "model data");
		return "test2"; //WEB-INF/view아래에  test2.jsp찾음
	}
	
	
	@GetMapping("/test2-2")
	public String test2_1(Map<String, Object> map) {
		
		//model이라는 바구니를 파라미터로 준비
		map.put("msg", "map data");
		return "test2"; //WEB-INF/view아래에  test2.jsp찾음
	}
	
	//파라미터 처리를 하고 싶다.
	@GetMapping("/test3")
	public String test3(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		
		model.addAttribute("id", id);
		
		
		return "test3"; //WEB-INF/view아래에  test3.jsp찾음
	}
	
	
	
	@GetMapping("/test3-2")
	public String test3_2(Model model, @RequestParam("myid") String id,
			@RequestParam(value="pw", defaultValue = "0000") String pw
			) {
		//파라미터 값 설정안했을 때 디폴트 밸류도 설정가능하다.
		
		model.addAttribute("id", id);
		
		
		return "test3"; //WEB-INF/view아래에  test3.jsp찾음
	}
	
}
