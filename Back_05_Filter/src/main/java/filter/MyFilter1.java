package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class MyFilter1
 */
public class MyFilter1 extends HttpFilter implements Filter {
       
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//인코딩 설정을 바꾸는 기능
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		//이부분에 코드 작성시->전처리
		System.out.println("필터1 요청");
		
		
		//필터를 연쇄적으로 쓸 때 뿐만아니라 무조건 써줘야한다.
		//체인 객체의 마지막에 필터의 끝인 서블릿이 오기 때문,
		//chain.doFilter를 안하면 서블릿까지 도달 x
		chain.doFilter(request, response);
		
		
		//이부분에 코드 작성시 -> 후처리
		System.out.println("필터1 응답");

	}

	
}
