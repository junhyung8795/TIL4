<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 결과</title>
</head>
<body>
	<h1>사용자 등록 결과</h1>
	<h2>등록 사용자 정보</h2>
	<!-- 코드작성 -->
	<div>아이디: ${user.id }</div>
	<div>비밀번호: ${user.password}</div>
	<div>이름: ${user.name}</div>
	<div>이메일: ${user.email}</div>
	<div>나이: ${user.age }</div>
</body>
</html>