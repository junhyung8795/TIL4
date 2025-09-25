package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebFilter("/board")
public class LoginFilter extends HttpFilter implements Filter {
       
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//보드라는 요청이 왔다면? 
		//우리의 게시판은 로그인한 사람만 볼 수 있게 하고 싶다.
		//세션에 loginUser 속성이 있는지 체크가 필요함.
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;

		HttpSession session = req.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			chain.doFilter(request, response);

		} else {
			resp.sendRedirect("/login.jsp");
		}
		


	}

	
}
