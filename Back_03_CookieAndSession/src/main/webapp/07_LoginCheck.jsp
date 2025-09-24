<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//로그인 처리를 하려고 jsp 사용. 
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	//id, pw -> DB를 통해 확인하고 -> 맞다면 로그인 성공을
	//틀리다면 로그인 실패
	// ssafy, 1234면 무조건 통과
	if(id.equals("ssafy") && pw.equals("1234")){
		//로그인 성공 -> 세션에다가 저장 해야겠다.
		session.setAttribute("loginUser", "Park");
		
		//HttpSession session1 = request.getSession(); 기본객체 session말고 세션 가져오는 다른 방법 둘다 같다.
		
		//페이지 이동
		//1. 포워딩 -> 적절하지 않음
		
		//2. 리다이렉트
		response.sendRedirect("08_Main.jsp");
		
		
		
	} else{
		//로그인 실패 
		//메인으로 튕기던지, 로그인창으로 튕기던지
		response.sendRedirect("07_LoginForm.jsp");
		
	}
	
	

%>
