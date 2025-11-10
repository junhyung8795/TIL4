<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<h1>사용자 목록</h1>

	<%-- request 영역에 users로 등록된 리스트를 반복문을 이용해 출력한다. --%>
	<!-- 코드작성 -->
	<c:forEach items="${users }" var="user">
		<div> 아이디  ${user.id }</div>
		<div> 비밀번호  ${user.password }</div>
		<div> 이름  ${user.name }</div>
		<div> 이메일  ${user.email }</div>
		<div> 나이  ${user.age }</div>
	</c:forEach>
</body>
</html>