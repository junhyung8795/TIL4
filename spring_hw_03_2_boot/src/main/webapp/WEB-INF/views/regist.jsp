<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<h1>SSAFY 사용자 관리</h1>
	<!-- 코드작성 -->
	<!-- 현재 경로가 이미 contextPath/regist일테니 그냥 ""으로 공백으로 냅둬도 contextPath/regist로 가게된다. -->
	<!-- action="/regist"를 하면 그냥 컨텍스트패스가 없이 그냥 localhost/regist로 가게되니 주의해야한다. -->
	
	<form action="regist" method="POST">

		<div>
			<label for="id">아이디</label> <input id ="id" name="id">
		</div>
		<div>
			<label for="password">비밀번호</label> <input type = "password" id="password" name="password">
		</div>
		<div>
			<label for="name">이름</label> <input id="name" name="name">
		</div>
		<div>
			<label for="email">이메일</label> <input id="email" name="email">
		</div>
		<div>
			<label for="age">나이</label> <input id="age" name="age">
		</div>
		<input type="submit" value="전송" />

	</form>
</body>
</html>