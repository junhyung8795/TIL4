<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<header>
		<%
		if (session.getAttribute("loginUser") == null) {
			//로그인이 안됐으니 로그인할 수 있는 form을 보여주던지
			//아니면 로그인페이지로 이동할 수 있는 링크를 보여주던지!
			response.sendRedirect("07_LoginForm.jsp");//이렇게하면 로그인 안될경우 절대로 메인페이지를 볼 수 없다
			//로그인 안되는 족족 로그인 폼 페이지로 리다이렉션도니까
		} else {
			out.println(session.getAttribute("loginUser") + "님이 로그인했습니다.");
		}
		%>

		<form action="07_Logout.jsp" method="POST">
			<button>로그아웃</button>
			<!--<a href = "07_Logout.jsp"></a>  -->

		</form>
	</header>

	<main>
		<h2>메인 내용</h2>

	</main>




</body>
</html>