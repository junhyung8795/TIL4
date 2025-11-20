package com.ssafy.mvc.interceptor;

import java.lang.reflect.Method;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.util.LoginRequired;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor{
	// 핸들러를실행하기전에 이 과정을 통해서 핸드러를 실행할지 말지를 체크하는 것!
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//true 이면 다음 과정을 계속 진행!
		//아니라면 false 면 취소!
		
		//1. 이 핸들러를 통해서 처리하게 되는 대상이 메서드인지 아닌지 체크!
		//핸들러메서드일수도 정적인 메서드일 수도 있기 때문우리는 컨트롤러 아래에 있는 핸들러메서드만 처리해야함
		//정적인 메서드들이나 다른 메서드 타입들은 모두 내보내기(PASS)
		if(!(handler instanceof HandlerMethod)) {
			//예는 정적 핸들러 같은 것이기 때문에 패스!
			return true;
		} 
			
			
		
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		
		//2. @LoginRequired 어노테이션이 붙어있는가를 확인
		if(!(method.isAnnotationPresent(LoginRequired.class))) {
			//로그인이 필요없는 상황이면 그냥 패스해라
			return true;
		}
		
		
		//@LoginRequired이 있는 상황
		
		//3. 이 사용자가 실제로 로그인한 사용자인지 체크
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		if(loginUser != null) {
			//로그인 돼 있구니
			return true;//로그인 한사람이니까 통과해도좋다.
		}
		
		//로그인이 필요한데 로그인 안돼있으니 거부
		return false;
	}
}
