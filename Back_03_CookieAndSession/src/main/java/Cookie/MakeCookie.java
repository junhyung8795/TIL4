package Cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/make")
public class MakeCookie extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용자가 보낸 정보는 어떤 객체에 들어있나? -> 리퀘스트 객체 안에 들어ㅇ있다/
		String key1 = req.getParameter("key");
		String value1 = req.getParameter("value");
		
		
		
		
		//쿠키 생성
		Cookie cookie = new Cookie(key1, value1);
		
		cookie.setMaxAge(60);//쿠키의 만료시간 결정 -> 초단위라서 60을 넣으면 1분을 의미한다. 1시간(3600), 1일(60 * 60 * 24 * 365)
		
//		cookie.setMaxAge(0); // 쿠키 삭제랑 같은 기능이다
		
		resp.addCookie(cookie);//응답으로 브라우저에 쿠키를 보내는 코드
		
		resp.sendRedirect("02_CookieResult.jsp");
		
		req.getSession();//jsp의 기본 객체를 서블릿 클래스에서도 쓸 수 있다. -> 다시 로그인 체크로 가서 스크립트렛에 작성해보자
		
	}
}
