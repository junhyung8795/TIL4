package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor{

	//로그인을 했는지 안했는지 알고 싶다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//특정 작업을 수행하려고했을 때, 로그인을 했는지 체크해보자.
		//로그인 정보는 session.에 저장돼있다.
		//컨트롤러에서는 HttpSessoion이 있으니 session에 setAttribute하면 되는데..
		//여기서는 안된다. 핸들러인터셉터는 파라미터로 session을 받을수가 없기 때문. 틀이 이미 정해진 메서드이기 때문에.
		//request.getSession()을 통해 가져올 수 있다.!
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			//해당조건에 통과가 되었다는 것은 로그인이 안돼있다는 뜻
			response.sendRedirect("login");
			return false;
		}
		
		
		return true;
	}
	
	
	
}
