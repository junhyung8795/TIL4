package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.mvc.model.dto.UserDto;

@Controller
public class RestController1 {

	// http://localhost:8080/rest1/test1
	@GetMapping("/rest1/test1")
	public String test1() {
		return "hello";// hello라고 하는 이름의 뷰가 있는지 찾는다.
	}

	// http://localhost:8080/rest1/test2
	@GetMapping("/rest1/test2")
	@ResponseBody
	public String test2() {
		return "hello";// 헬로라는 데이터 그 자체를 보내보자
	}

	// http://localhost:8080/rest1/test3
	@GetMapping("/rest1/test3")
	@ResponseBody
	public Map<String, String> test3() {
		Map<String, String> data = new HashMap<>();
		data.put("id", "ssafy");
		data.put("pw", "1234");
		return data;// 맵을 반환해서 리스폰스바디에 넣으면
		// 별도의 어노테이션 없이 자동으로 Java객체와 JSON객체를 맵핑해준다.
		// 스프링부트에서 데이터를 JSON을 많이 써서 잭슨 데이터바인드라는 애를 내장하고 있다.
	}

	// http://localhost:8080/rest1/test4
	@GetMapping("/rest1/test4")
	@ResponseBody
	public UserDto test4() {
		// MyPage를 눌러서 유저의 정보를반환해야하는 상황을 가정
		// 들어온 ID를 이용하여 서비스 호출 -> DAO호출 -> DB에서 정보를 가져다 주겠다.
		UserDto user = new UserDto("ssafy", "1234", "박준형");
		// UserDto를 JSON객체로 맵핑해서 전달해줫음
		return user;
	}

	// http://localhost:8080/rest1/test5
	@GetMapping("/rest1/test5")
	@ResponseBody
	public List<UserDto> test5() {
		//유저 전체 목록을 불러오는 상황을 가정
		List<UserDto> list = new ArrayList<>();
		list.add(new UserDto("ssafy", "1234", "박준형"));
		list.add(new UserDto("ssafy2", "1234", "박준형"));
		list.add(new UserDto("ssafy3", "1234", "박준형"));
		list.add(new UserDto("ssafy4", "1234", "박준형"));
		list.add(new UserDto("ssaf5", "1234", "박준형"));
		list.add(new UserDto("ssafy67", "1234", "박준형"));
		return list;
	}
}
