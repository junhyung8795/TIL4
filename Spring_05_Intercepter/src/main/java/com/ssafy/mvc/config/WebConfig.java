package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.AInterceptor;
import com.ssafy.mvc.interceptor.BInterceptor;
import com.ssafy.mvc.interceptor.CInterceptor;
import com.ssafy.mvc.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	// 인터셉터들은 @Component만 붙여서 동작하진 않는다.
	// 웹과 관련된설정 파일에 등록을 해줘야한다.

	// 인터셉터들을 빈으로 등록해둔상태 @Component붙엿으니까!
	// 단 따로 설정파일에 주입을 해줘야 그제서야 동작한다.
	@Autowired
	private AInterceptor aInterceptor;

	@Autowired
	private BInterceptor bInterceptor;

	@Autowired
	private CInterceptor cInterceptor;

	
	@Autowired 
	private LoginCheckInterceptor checkInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
//		registry.addInterceptor(aInterceptor).addPathPatterns("/hello");// addInterceptor는 인자로 핸드러 인터셉터를 받는데 이 구현체가 들어감.
//		registry.addInterceptor(bInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(cInterceptor).addPathPatterns("/hello");
		
		//우리의 페이지는 모두 다 로그인을 해야만 진행할 수 있어! 단로그인페이지는 들어갈 수 있게해줄게.
		registry.addInterceptor(checkInterceptor).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/WEB-INF/**");
		
	}

}
