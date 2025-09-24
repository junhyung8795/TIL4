<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	
	<!-- pageContext.setAttribute();으로 어트리뷰트 설정된걸 getAttribyte안쓰고 EL로 가져옴  -->
	${pageScope.name}<br>
	${requestScope.name}<br>
	${sessionScope.name}<br>
	${applicationScope.name}<br>
	
	<!-- EL의 내장 객체로 쿠키도 쉽게 가져옴 -->
	${cookie.JSESSIONID }<br>
	
	<h3>내이름은? </h3>
	${name} <!-- 
	
	${pageScope.name}<br>
	${requestScope.name}<br>
	${sessionScope.name}<br>
	${applicationScope.name}<br>위에서 부터 아래로 맨 처음 나온 name을 출력한다. 스코프가 좁은거부터!
	명시적으로하는게 더 좋긴하다!
	-->



</body>
</html>