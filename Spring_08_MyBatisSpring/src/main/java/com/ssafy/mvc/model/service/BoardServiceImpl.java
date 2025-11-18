package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;

//빈은 ,어노테이션이 붙은건 빈이 되니까 구현체에 붙여야한다. 인터페이스가 아니라!
@Service
public class BoardServiceImpl implements BoardService{
	//BoardDao를 호출해서 DB작업을 수행해야겠다.
	
	private final BoardDao boardDao;
	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		System.out.println("전체목록주세요");
		
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성");
		boardDao.insertBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyBoard(Board board) {
		// TODO Auto-generated method stub
		
	}
	
}
