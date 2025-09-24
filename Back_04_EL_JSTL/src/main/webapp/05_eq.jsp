<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

	<!-- 파라미터를 꺼내서 보자 id라고 하는 파라미터가 넘어왔다! -->
	<!-- JSP방식 -->
	<%=request.getParameter("id")%>
	<br>
	<%=request.getParameter("id") == "ssafy"%>
	<br>
	<%-- <%=request.getParameter("id").equals("ssafy")%> --%>
	<br>
	<!-- EL방식 -->
	<!-- EL방식은 쿼리스트링에 아무것도 없어서 null이 되면 빈칸만 나오고 null이라고 화면 출력안나온다. -->
	${param.id}
	${param.id == "ssafy"}<!-- 내부적으로 이퀄스를 쓴다.  -->
	${param.id eq "ssafy"}
	
</body>
</html>