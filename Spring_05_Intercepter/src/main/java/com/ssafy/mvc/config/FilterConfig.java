package com.ssafy.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.mvc.filter.MyFilter;

//설정파일을 만들자
@Configuration
public class FilterConfig {
	
	
	@Bean
	public FilterRegistrationBean<MyFilter> myfilter(){
		FilterRegistrationBean<MyFilter> filterRegistrationBean  = new FilterRegistrationBean<>();
		
		filterRegistrationBean.setFilter(new MyFilter());//어던 필터를 적용할지 선택
		filterRegistrationBean.addUrlPatterns("/hello");//"/hello"라는 경로로 요청이 왓을 때만 이 필터를 동작시키겠다는 설정
		filterRegistrationBean.setOrder(1);//어떤 순서로 필터를 등록할지 선택
		
		
		return filterRegistrationBean;
	}
}
