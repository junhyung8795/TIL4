package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.repository.BoardRepository;
import com.ssafy.board.model.repository.BoardRepositoryImpl;

//싱글톤으로 만든다.
//매번 생성해서 쓸 것이 아니고, 서블릿 컨테이너가 관리해주지 않으니
//직접 싱글톤으로 만들어 관리해야한다.
public class BoardServiceImpl implements BoardService{
	private static BoardService service = new BoardServiceImpl();
	private BoardRepository repo = BoardRepositoryImpl.getInstance();
	
	
	private BoardServiceImpl() {
	}
	
	public static BoardService getInstance() {
		return service;
	}
	
	@Override
	public List<Board> getList() {
		
		return repo.selectAll();
	}

	@Override
	public Board getBoard(int id) {
		//상세로 들어온다.
		
		repo.updateViewCnt(id);
		
		
		return repo.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
		//게시글을 등록 -> Repository호출
		repo.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBoard(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
