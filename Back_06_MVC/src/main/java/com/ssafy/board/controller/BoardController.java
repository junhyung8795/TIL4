package com.ssafy.board.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	// 컨트롤러가 서비스를 가지고 있어야한다.
	private BoardService service = BoardServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");

		switch (act) {
		case "writeform":
			doWriteForm(request, response);
			break;
		case "write":
			doWrite(request, response);
			break;
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("board", service.getBoard(id));
		request.getRequestDispatcher("/WEB-INF/board/detail.jsp").forward(request, response);

	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체조회 -> 서비스 호출 -> 레포지토리 -> 메모리에서 꺼내오고 -> 서비스로 돌아오고 -> 컨트롤러로 다시 돌아온다.
		List<Board> list = service.getList();
		request.setAttribute("list", list);// 속성으로 리퀘스트에 담아 보낸다.
		// list.jsp를 보여줘야해
		request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// 게시글 객체를 생성
		Board board = new Board(title, writer, content);
		// 등록 -> 서비스 호출 -> 레포지토리(현재는 메모리상) -> 메모리저장 -> 레포->서비스->컨트롤러
		service.writeBoard(board);

		// 등록을 확인or메인으로 보내기
		// 1. 메인 튕기기-> index.jsp 리다이렉트

		// 2. 조회 -> 리다이렉트
		// 2-1. 전체 조회
		response.sendRedirect("board?act=list");
		// 2-2. 상세 조회
//		response.sendRedirect("board?act=detail?id=게시글id");

	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 작성페이지를 제공하는 컨트롤러 -> 포워딩방식으로 한다.
		// 모든 jsp는 WEB_INF폴더 안에 들어갈 것이다.
		// 확장자로 절대 접근할 수 없다.
		// 리다이렉트를 하면 WEB_INF안에 있는거 접근 못한다. url을 바꾸고 접근하려고하니까.
		// 포워딩은 내부적으로 돌릴땐 WEB-INF에 있는거 접근가능하다.
		request.getRequestDispatcher("/WEB-INF/board/writeform.jsp").forward(request, response);

	}
}
