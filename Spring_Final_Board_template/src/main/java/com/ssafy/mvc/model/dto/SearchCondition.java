package com.ssafy.mvc.model.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchCondition {
	private String key; //= "none";
	private String word;
	private String orderBy;
	private String orderByDir;


}
