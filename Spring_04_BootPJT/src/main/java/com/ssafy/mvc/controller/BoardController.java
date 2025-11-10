package com.ssafy.mvc.controller;

import java.util.ArrayList;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Board;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
//게시글을 등록하기 위해선 등록 jsp가 있어야함.
//여기에 어떻게 접근하냐? -> WEB-INf안의 페이지는 직접 접근못하니 컨트롤러로
//포워딩해야한다!

	// 서비스 호출 -> DAO -> DB
	private final ArrayList<Board> list = new ArrayList<>();

//	public BoardController() {
	// 생성자 주입으로 리스트를 초기화할 수도 있다.
//		this.list = new ArrayList<>();
//	}

	// 등록 페이지 접근요청 처리
	@GetMapping("/writeform")
	public String writeform() {
		return "board/writeform";
	}

	


	// 등록요청 처리
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		//등록하는 서비스메서드를 호출할거야.
		//모델 어트리뷰트말고도 리퀘스트 파람 어노테이션, httpServletRequest어노테이션으로도
		//같은 기능을 구현할 수 있다.
		list.add(board);
//		return "/board/list"; 포워딩방식으로 가면 안됨. 정보가 안에 남아있어서
		//리다이렉트 요청으로 이전 요청의 정보를 안가져가야한다.
		return "redirect:list";
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		// 정석: 전체 목록을 가져오는 서비스 메섣 호출해서 바구니에 결과 넣기
		model.addAttribute("boardList", list);
		return "/board/list"; // WEB-INF/views/board/list.jsp
	}
	
	
	
	
	
	
}
