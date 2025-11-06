package com.ssafy.mvc;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 핸들러맵핑 정의 (전화번호부)
	private Map<String, Controller> handlerMappings;
	
	//뷰 리졸버 선언
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		handlerMappings = new HashMap<>(); // 초기화
		
		// 경로(path) <-> 서블릿(Servlet) 맵핑(=연결해주겠다)
		handlerMappings.put("/hello", new HelloController());
		handlerMappings.put("/user", new UserController());
		
		//뷰리졸버 할당. -> 접두사 접미사 설정!
		viewResolver = new ViewResolver("/WEB-INF/views", ".jsp");
		
	}
	

	private String extractPath(HttpServletRequest req) {
		// 1단계 : 사용자가 보낸 전체의 URI 경로를 가져오겠다...!
		String uri = req.getRequestURI();
//		System.out.println("uri:" + uri);
		
		// 2단계 : 사용자가 요청한 ContextPath 만 가져오기...!
		String contextPath = req.getContextPath();
//		System.out.println("context path:" + contextPath);
		
		// 3단계 : 사용자의 전체 URI 에서 Context Path를 문자열에서 뺀다...!
		String path = uri.substring(contextPath.length());
		return path;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 1단계 : 경로를 추출한다...!
		String path = extractPath(req);
		
		// 2단계 : Map에서 서블릿(handler)을 찾는다...!
		Controller controller = handlerMappings.get(path);
		
		// 3단계: 만약 서블릿을 못찾았다면...?
		if(controller == null) {
			// 404 페이지를 보여주겠다...!
			resp.getWriter().write("<h1>Not Found Page</h1>");
		}else {
			// 해당 서블릿에게 요청을 위임
			// 경로(논리적)를 반환받는다.
			String viewName = controller.service(req, resp);
			
			//해당 뷰파일이 있는 물리적 경로를 가져옴!
			String viewPath = viewResolver.resolve(viewName);
			
			
			//화면 구성은 dispatcherServlet이 진행하게 됐다.
			req.getRequestDispatcher(viewPath).forward(req, resp);
		}
	}
}












