import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view")

//생명 주기: 사용자가 요청을 보내었을 때 서블릿이 로드가 필요하다 생각이 되면 서블릿 로드!
//init() 딱 한번만 실행(싱글톤) -> service -> service -> ...destroy()
public class ViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//view는 인스턴스 변수인데 어떻게 view라는 변수카운트가 웹 화면에 증가돼서 표현되는가>? -> 생명주기상 먼저 init으로 인해
	int view = 0;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("이닛! 시작!");
	}

	//서블릿에 요청을 보내게 되면 초기에 실행되는 메서드 service()
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서비스 호출!");
		PrintWriter writer = resp.getWriter();
//		writer.println("Hello World");
		
		writer.println("<html>");
		writer.println("<head></head>");
		writer.println("<body>");
		writer.println("<h1>" + view + "</h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.flush();
		
		view++;
	}

	@Override
	public void destroy() {
		System.out.println("소멸!");
	}
	
	
}
