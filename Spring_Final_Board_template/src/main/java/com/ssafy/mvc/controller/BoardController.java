package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;
import com.ssafy.mvc.util.LoginRequired;
import com.ssafy.mvc.util.LoginUser;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	// 등록페이지
	@LoginRequired
	@GetMapping("/writeform")
	public String writeform(HttpSession session) {
//		String userId  = session.getAttribute("loginUser");
//		if(userId == null){
//			return "로그인페이지~";
//		}
		return "board/writeform";
	}

	// 등록하기
	@LoginRequired
	@PostMapping("/write")
	public String write(@ModelAttribute Board board, @LoginUser User loginUser) {
		// 서비스 호출
		System.out.println(board);
		board.setWriter(loginUser.getName());
		boardService.writeBoard(board);

		// 전체목록을 보여주도록 해줘
		// 이전 요청정보가 들어갈수 있으니 포워드방식이 아닌 리다이렉트로 보내줘야한다.
		return "redirect:/list";
	}

	// 목록을 보여주는 요청
	@GetMapping("/list")
	public String list(Model model) {

		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}

	// 상세게시글 보여줘
	@LoginRequired
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		model.addAttribute("board", boardService.readBoard(id));
		return "board/detail";
	}

	@LoginRequired
	@PostMapping("/update")
	// 매번 HttpSesision에서 뭐 가져오는거 불편하다!
	// Session을 통해서 User객체를 자동으로 가져와주는 마법이 일어나면 되지 않을까?
	// @ModelAttribute같은 세션에서 유저정보를 자동으로 가져오는 방법은 뭐가 있을까?
//	public String update(@ModelAttribute Board board, HttpSession session) {
//		User loginUser = (User) session.getAttribute("loginUser");
//		if(loginUser.getName().equals(board.getWriter())) {
//			boardService.modifyBoard(board);
//		}
//		return"redirect:detail?id=" + board.getId();
//	}
	public String update(@ModelAttribute Board board, @LoginUser User loginUser) {
		
		if (loginUser.getName().equals(board.getWriter())) {
			boardService.modifyBoard(board);
		}
		return "redirect:detail?id=" + board.getId();
	}

	
	@LoginRequired
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id, @LoginUser User loginUser) {
		return "";
	}
	
	
	
	@GetMapping("/search")
	public String search(@ModelAttribute SearchCondition condition, Model model) {
		// 두번째인자로는 검색한 리스트/정렬한 리스트 -> 서비스호출
		model.addAttribute("boardList", boardService.search(condition));
		return "board/list";
	}

}
