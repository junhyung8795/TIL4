package com.ssafy.mvc.model.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

//빈은 ,어노테이션이 붙은건 빈이 되니까 구현체에 붙여야한다. 인터페이스가 아니라!
@Service
public class BoardServiceImpl implements BoardService{
	//BoardDao를 호출해서 DB작업을 수행해야겠다.
	
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Transactional
	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		System.out.println("전체목록주세요");
		
		return boardDao.selectAll();
	}
	@Transactional
	@Override
	public Board readBoard(int id) {
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}
	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성");
		boardDao.insertBoard(board);
	}
	@Transactional
	@Override
	public void removeBoard(int id) {
		// TODO Auto-generated method stub
		System.out.println("게시글 삭제");
		boardDao.deleteBoard(id);
		
	}
	@Transactional
	@Override
	public void modifyBoard(Board board) {
		// TODO Auto-generated method stub
		System.out.println("게시글 수정");
		boardDao.updateBoard(board);
	}
	@Transactional
	@Override
	public List<Board> search(SearchCondition condition) {
		condition.setWord("%" + condition.getWord() + "%");
		return boardDao.search(condition);
	}
	
}
