package com.ssafy.mvc.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Board {
	private int id;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int viewCnt;

	
	

	public Board(int id, String title, String writer, String content, String regDate, int viewCnt) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}

	

}
