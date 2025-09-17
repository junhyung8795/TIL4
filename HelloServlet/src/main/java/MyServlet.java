import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/my")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서블릿에 요청을 보내게 되면 초기에 실행되는 메서드 service()
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자의 요청이 들어가 있는 객체가 HttpServletRequest req
		//메서드: GET / POST 정보..
		String method =req.getMethod();
		System.out.println(method);//GET이라고 출력
		//아이피 정보... 
		String address = req.getRemoteAddr();
		System.out.println(address);
		
		//URL 경로
		String url = req.getRequestURI();
		System.out.println(url);
		//쿼리스트링 http://localhost:8080/hello?**name=홍길동**
		String name = req.getParameter("name");
		System.out.println(name);
		
		//사용자에게 응답을 하기 위한 객체 HttpServletResponse resp
		//사용자에게 보낼 패킷의 헤더 정보 
		//사용자에게 보낼 body 데이터...
//		OutputStream out = resp.getOutputStream();// 바이너리 스트림 (1byte)
//		out.write('A');
		
		PrintWriter writer = resp.getWriter();
//		writer.println("Hello World");
		
		writer.println("<html>");
		writer.println("<head></head>");
		writer.println("<body>");
		writer.println("<h1>Hello World</h1>");
		writer.flush();
		
		
	}
	
	
}
