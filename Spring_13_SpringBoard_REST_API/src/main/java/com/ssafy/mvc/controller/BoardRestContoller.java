package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-board")
@Tag(name = "Board RESTful API", description = "CRUD를 할 수 있는 API")
public class BoardRestContoller {
	// 서비스 의존성이 필요함
	private final BoardService boardService;

	@Autowired
	public BoardRestContoller(BoardService boardService) {
		this.boardService = boardService;
	}

//	//게시글 전체 조회
//	@GetMapping("/board")
//	public ResponseEntity<List<Board>> list(){
//		List<Board> list = boardService.getBoardList();
//		//return new ResponseEntity<>(list, HttpStatus.OK);
//		return ResponseEntity.ok(list);//둘 중 택일!
//	}
//	

	// 게시글 검색 조회
	@GetMapping("/board")
	@Operation(summary = "게시글 조회(검색 가능)", description = "조건을 명시하여 게시글을 검색할 수 있다.")
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {
		System.out.println(condition);

		List<Board> list = boardService.search(condition);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	// 게시글 상세 조회
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id) {
		Board board = boardService.readBoard(id);
		if (board != null)
			return ResponseEntity.ok(board);// new로 생성안해도 내부적으로 알아서 만들어서 던져줌
		// board가 null인 상황
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

//	// 게시글 등록(form)
//	@PostMapping("/board")
//	public ResponseEntity<Void> write(@ModelAttribute Board board) {
//
//		System.out.println(board);
//		boardService.writeBoard(board);
//		System.out.println(board);
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
//	}

	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	@Hidden // 스웨거 문서상에서만 지워진다.
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		boolean isDeleted = boardService.removeBoard(id);
		// 지워졌으면 true 안지워졌으면 false

		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK).body("Board Delete");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");

	}
	// 그리고 스웨거를 쓰면 리퀘스트바디를 스프링에 있는 리퀘스트바디로 써야한다.

	// 게시글 수정(JSON)
//	@PutMapping("/board")
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board) {
		board.setId(id);
		boardService.modifyBoard(board);

		// 분기처리
		// 1. ID가 없을 수도 있다.
		// 2. 수정할 데이터가 완벽하지 않을 수도 있다.
		// 3. 정상적으로 수정이 완료되지 않을 수도

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 게시글 등록(form) + 파일도 같이 처리해보자
	//파일 업로드를 하려면 post 방식이여야 한다!
	//
	@PostMapping("/board")
	public ResponseEntity<Void> write(@RequestParam("file") MultipartFile file, @ModelAttribute Board board) {
		System.out.println(file.getOriginalFilename());
		System.out.println(board);
		
//		if(file == null) {
//			boardService.writeBoard(board);
//		}
		
		boardService.fileUpload(file, board);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
