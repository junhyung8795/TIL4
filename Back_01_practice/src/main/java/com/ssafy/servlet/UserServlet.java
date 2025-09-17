package com.ssafy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Person> memory = new ArrayList<>();

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//회원가입 요청이 왔다!
//		doProcess(req, resp);
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doProcess(req, resp);
//	}
//       
//	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
//		String act = req.getParameter("act");
//		
//		//act: 등록, 조회, 수정, 삭제		
//	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 두겟 두 포스트는 서비스로부터 뻗어난 뿌리임
		// 메서드별로 아닌 그냥 act로 들어온 밸류들로 구분할 거면 그냥 서비스로 구현1

		// 현재 크롬의 회원가입 페이지(톰켓서버가 준)의 등록이라는 버튼(submit)을 눌러서 톰켓 서버로 통로가 하나 뚫리는데
		// 이 통로 이름이 request. 여기에 이름(name), 나이(age), 성별(gender), 요청이름(act)도 날아간다.
		// 이거 /user로부터 날아오던데 누가 처리할 수 있더라? => UserServlet : 제가 할 수 있습니다!
		// 그리고 GEt Post같은 메서드로 구분하지않고 싶으니까 서비스메서드에서 act가 뭔지 파악한 뒤에 그에 따른 메서드를 실행!
		// 예를 들어 act가 regist면 doRegist를 실행! 인자로 req를 넣어서 쿼리스트링 값들을 전부 넣는다.
		response.setContentType("text/html; charset=UTF-8");
		String act = request.getParameter("action");
		if(act == null) {
			act = "";
		}
		
		switch (act) {
		case "regist":
			doRegist(request, response);
			break;
		case "getList":
			doList(request, response);
			break;

		}

	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter writer = response.getWriter();

		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>회원 목록</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h2>등록된 사람 정보</h2>");
		writer.append("<ul>");
		if (memory.size() > 0) {
			for (int i = 0; i < memory.size(); i++) {
				writer.append("<li>");
				writer.append(memory.get(i).getName());
				writer.append("</li>");
			}
		}else {
			writer.append("<li>등록된 사람이 없다.(한명도)</li>");
		}

		writer.append("</ul>");

		writer.append("</body>");
		writer.append("<html>");

	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 회원 정보를 꺼내자
		// getParameter에는 key값이 들어온다. (name이라는 key에 담긴 밸류)
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");// 취미는 체크박스라서 여러개의 밸류가 나올 수 있다.

		Person p = new Person(name, age, gender, hobbies);

		PrintWriter writer = response.getWriter();

		memory.add(p);

		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>등록정보</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h2>등록된 사람 정보</h2>");
		writer.append(p.toString());
		writer.append("</body>");
		writer.append("<html>");

	}

}
