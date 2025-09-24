import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class HelloServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session 가져오기, 개별 사용자 저장소
		HttpSession  session = req.getSession();
		
		//데이터 추가
		session.setAttribute("name", "홍길동");
		
		//데이터 가져오기
		String name = (String) session.getAttribute("name");
		System.out.println(name);
		
		//가지고 있는 키들을 모두 가져오기
		Enumeration<String> names =  session.getAttributeNames();
		while(names.hasMoreElements()) {
			String _name = names.nextElement();
			System.out.println(_name);
		}
		
		//데이터를 삭제
		session.removeAttribute("name");
		
		//세션의 고유 아이디를가져오기!
		System.out.println("SID: " + session.getId());
		
		//세션의 타임아읏 설정
		session.setMaxInactiveInterval(3600); //사용자 세션이 1시간동안 유지
		
		//세션을 무효화()속성 모두 삭제
		session.invalidate();
		
		
	}
}
