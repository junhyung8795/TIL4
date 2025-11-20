package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.UserDto;

@RestController
@RequestMapping("/rest3")
public class RestController2 {
	// http://localhost:8080/rest2/test1
	@GetMapping("/test")
	public String test1() {
		return "GET";
	}

	@PostMapping("/test")
	public String test2() {
		return "POST";
	}

	@PutMapping("/test")
	public String test3() {
		return "PUT";
	}

	@DeleteMapping("/test")
	public String test4() {
		return "DELETE";
	}
}
