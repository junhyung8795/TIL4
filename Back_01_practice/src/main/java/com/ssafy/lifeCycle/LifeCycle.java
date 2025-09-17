package com.ssafy.lifeCycle;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//어떤 경로로 불러야 등록할 수 있나?
//1. web.xml에 등록하거나
//2. 아ㅓ노테이션으로 등록하거나

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	//멤버 필드
	int initCount = 1;
	int doGetCount = 1;
	int destroyCount = 1;
	
	public LifeCycle() {
		System.out.println("기본 생성자 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출" + (initCount++));
	}
	//기본생성자 호출과 init은 한번만 호출되고 doGet만 새로고침 시 여러번 호출된다.
	//해당 URL에 요청을 보내는 시점에 init과 기본생성자를 호출한다. 그때부터 라이프사이클이 시작!
	//꼭 GET요청뿐만이 아니라 POST든 뭐든 요청을 보내는 시점에 호출!
	//기본적으로 서블릿 인스턴스는 싱글톤으로 관리된다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출" + (doGetCount++));
	}
	
	
	@Override
	public void destroy() {
		//서블릿이 소멸할 때 호출
		System.out.println("destroy 메서드 호출" + (destroyCount++));
	}
}
