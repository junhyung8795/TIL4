package com.ssafy.mvc.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component//이런 방식의 등록은 모든 경로와 매핑을 한것과 동일한 느낌이다.
public class MyFilter implements Filter {

	@Override//@WebFilter나 we.bxml에 필터를 등록했어야했는데, 스프링 부트라서 하나의 빈으로 관리되니 이런게 없다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("서블릿 전2");
		chain.doFilter(request, response);
		System.out.println("서블릿 후2");

	}
}
