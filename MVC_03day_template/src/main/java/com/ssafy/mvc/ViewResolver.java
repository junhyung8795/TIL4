package com.ssafy.mvc;

public class ViewResolver {
	//접두사 접미사를 담을 수 있는 필드
	
	
	
	private String prefix;
	private String suffix;
	public ViewResolver(String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	// resolve구현
	//논리적인 뷰이름을 물리적인 뷰의 경로로 바꿔준다.
	public String resolve(String viewName) {
		String viewPath = prefix + viewName + suffix;
		//접두사는 "WEB-INF/views/"가 되고 접미사는 ".jsp"이면 viewName이 hello면 전체 물리적 경로가 완성된다!
		return viewPath;
	}
	
}
