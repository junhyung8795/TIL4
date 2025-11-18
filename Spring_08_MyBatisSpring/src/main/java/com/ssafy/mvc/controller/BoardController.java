package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.service.BoardService;

@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//등록페이지
	@GetMapping("/writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	//등록하기
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		//서비스 호출
		boardService.writeBoard(board);
		
		//전체목록을 보여주도록 해줘
		//이전 요청정보가 들어갈수 있으니 포워드방식이 아닌 리다이렉트로 보내줘야한다.
		return "redirect:list";
	}
	
	//목록을 보여주는 요청
	@GetMapping("/list")
	public String list(Model model) {
		
		model.addAttribute("boardList", boardService.getBoardList());
		return "/board/list";
	}
	
	
	
	//상세게시글 보여줘
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		model.addAttribute("board", boardService.readBoard(id));
		return "/board/detail";
	}
	
	
	
	
	
	
	
	
}
