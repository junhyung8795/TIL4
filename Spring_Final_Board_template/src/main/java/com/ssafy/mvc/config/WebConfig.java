package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.AdminInterceptor;
import com.ssafy.mvc.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Autowired
	LoginCheckInterceptor loginCheckInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminInterceptor).addPathPatterns("/users");
		registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**")
		.excludePathPatterns("/img/**")
		.excludePathPatterns("/login");
	}
	
	
	
}
