package com.ssafy.board.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Board;

//싱글톤으로
public class BoardRepositoryImpl implements BoardRepository {

	// DB와 소통을 못하니 현재는 메모리에 저장할 것임.
	// 게시글 저장 관리 -> 맵, 리스트
	private List<Board> list = new ArrayList<>();
	private Map<Integer, Board> map = new HashMap<>();

	private static BoardRepository repo = new BoardRepositoryImpl();

	private BoardRepositoryImpl() {
		// 더미데이터
		Board tmp = new Board("제목", "Park", "더미 내용");
		map.put(1, tmp);
		list.add(tmp);
	}

	public static BoardRepository getInstance() {
		return repo;
	}

	@Override
	public List<Board> selectAll() {

//		return list;
		List<Board> tmp = new ArrayList<>();

		for (int key : map.keySet()) {
			tmp.add(map.get(key));
		}
		return tmp;

//		return (List<Board>)map.values();
	}

	@Override
	public Board selectOne(int id) {
		// lsit
//		for(Board board: list) {
//			if(board.getId() == id) {
//				return board;
//			}
//		}
//		return null;

		// map을 쓴다면
		return map.get(id);
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		list.add(board);
		map.put(board.getId(), board);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateViewCnt(int id) {
		Board b = map.get(id);
		b.setViewCnt(b.getViewCnt() + 1);

	}

}
