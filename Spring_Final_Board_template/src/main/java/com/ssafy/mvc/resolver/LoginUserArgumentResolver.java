package com.ssafy.mvc.resolver;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ssafy.mvc.util.LoginUser;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//핸들러에 있는 매개변수의 값을 이러한 리졸버를 통해서 주입하는 과정이 일어난다.
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

	// 해당 리졸버가 주어진 파라미터에 적용이 가능한지를 판단하는 메서드임.
	// 해당 값을 true로 반환하면 해당 리졸버가 실행 가능한 것으로 판단이 된다.
	// false로 반환하면 다른 변환 가능한 리졸버를 찾게된다.
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// @LoginUser라는 어노테이션이 붙어있는 파라미터이면서
		// 해당 파라미터타입이 User라면 이 리졸버를 사용할거에요.

		if (parameter.hasParameterAnnotation(LoginUser.class) && parameter.getParameterType().equals(User.class)) {
			return true;
		}
		return false;
	}

	// 해당 리졸버가 주어진 파라미터에 주입할 객체(데이터)를 처리하는 역할
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// resolver가 붙으면 변환하는 역할임
		// 주어진 매개변수들을 통해서 session객체를 먼저 얻어오는 일부터 해야한다.
		// webRequest 이게 서블릿 리퀘스트를 들고 있어서 여기서 HttpServletRequest를 가져올 수 잇다.
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		HttpSession session = request.getSession();
		
		//세션에서 유저객체 반환
		return session.getAttribute("loginUser");
	}

}
