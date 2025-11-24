package com.ssafy.mvc.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

//빈은 ,어노테이션이 붙은건 빈이 되니까 구현체에 붙여야한다. 인터페이스가 아니라!
@Service
public class BoardServiceImpl implements BoardService{
	//BoardDao를 호출해서 DB작업을 수행해야겠다.
	
	private final BoardDao boardDao;
	private final ResourceLoader loader;
	
	public BoardServiceImpl(BoardDao boardDao,  ResourceLoader loader) {
		this.boardDao = boardDao;
		this.loader = loader;
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
	public boolean removeBoard(int id) {
		// TODO Auto-generated method stub
		System.out.println("게시글 삭제");
		int result = boardDao.deleteBoard(id);
		return result == 1;
		
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

	@Override
	public void fileUpload(MultipartFile file, Board board) {
		if(file != null && file.getSize() > 0) {
			//파일을 저장한다.
			String fileName = file.getOriginalFilename(); // 확장자를 추출하려고할 때를 고민해보자
			String fileId = UUID.randomUUID().toString(); // 확장자가 사라지니까 이 줄에서 split을 잘 써보자
		
			
			board.setFileId(fileId);
			board.setFileName(fileName);
			
			//저장
			try {
				Resource resource = loader.getResource("classpath:/static/img");
				file.transferTo(new File(resource.getFile(), fileId));
				
				boardDao.insertBoard(board);
				boardDao.insertFile(board);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//fileId로 저장한다. 이름으로 저장하면 중복될 수 있기 때문에. 
			
		} 
		//파일 저장로직이 발동안해도 보드는 저장해야한다,
		
	}
	
}
