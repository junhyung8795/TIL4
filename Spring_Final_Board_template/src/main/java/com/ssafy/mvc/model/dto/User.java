package com.ssafy.mvc.model.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.ToString;

@Getter
@Service
@ToString
public class User {
	private String id;
	private String password;
	private String name;
	private int curriculumCode;
	private String curriculumName;


}
