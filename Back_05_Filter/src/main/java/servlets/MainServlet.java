package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println(request.getContextPath() );		
		switch(act) {
		case "login":
			doLogin(request, response);
			break;
		}
		
		
	}


	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//id, pw 통해 유저인지 체크하기.
		if(id != null && pw != null) {
			//둘다 널인지를 먼저 체크 
			
			//세션에다가 저장
			//불린 파라미터가 들어가는 겟세션이있는데,
			//true일땐, 세션이 있으면 있는걸 반환하고 없다면 새로 만들어서 반환
			//fasle일땐, 세션이 있으면 있는걸 반환하고 없다면 그냥 null반환
			HttpSession session = request.getSession(false);
			session.setAttribute("loginUser", id);
//			response.sendRedirect("index.html");
			
			response.setStatus(302);
			response.setHeader("Location", "index.html");
			
			
			
			
			
		} else {
			//로그인 실패
			//1. 메인으로 튕기기 /2. 로그인 페이지 다시 보여주기
			
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		
		
		
		
		
		
	}
}
