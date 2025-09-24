import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Application (ServletContext) 가져옥;, 전역저장소
		ServletContext  application = req.getServletContext();
		
		//데이터 추가
		application.setAttribute("name", "홍길동");
		
		//데이터 가져오기
		String name = (String) application.getAttribute("name");
		System.out.println(name);
		
		//가지고 있는 키들을 모두 가져오기
		Enumeration<String> names =  application.getAttributeNames();
		while(names.hasMoreElements()) {
			String _name = names.nextElement();
			System.out.println(_name);
		}
		
		//데이터를 삭제
		application.removeAttribute("name");
	}
}
