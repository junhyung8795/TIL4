package com.ssafy.board.test;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyBatisConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		
		MyBatisConfig config = new MyBatisConfig();
		
		//전체 게시글 조회
		//쿼리문을 날리기 위해서 
		SqlSession session = MyBatisConfig.getFactory().openSession(true);
//		List<Board> list = session.selectList("com.ssafy....blabla");
		//Dao구현체를 만들어버림.
		BoardDao dao = session.getMapper(BoardDao.class);
		
		for(Board board: dao.selectAll()) {
			System.out.println(board);
		}
		
		
		//상세 게시글 조회
		System.out.println(dao.selectOne(1));
		
		
		//게시글 등록
		Board tmp = new Board("점심 뭐먹지?", "박준형", "떡볶이 먹을래");
		dao.insertBoard(tmp);		
		System.out.println(dao.selectOne(3));

		
		//게시글 수정
		Board tmp2 = dao.selectOne(3);
		tmp2.setContent("떡볶이 말고 돈까스");
		dao.updateBoard(tmp2);
		System.out.println(dao.selectOne(3));
		
		
		
		//게시글 삭제
		dao.deleteBoard(1);
		System.out.println(dao.selectOne(1));
		
		
		session.close();
		
		
		
	}
}
