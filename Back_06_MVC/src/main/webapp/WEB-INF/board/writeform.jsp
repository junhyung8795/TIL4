<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 작성하기 위한 폼태그 작성 -->
	<form action="board" method="POST">
		<input type="hidden" name="act" value="write">
		<div>
			글제목 : <input type="text" name="title">
		</div>
		<div>
			글쓰니 : <input type="text" name="writer" value="익명">
		</div>
		<div>
			글내용 :
			<textarea rows="10" cols="30" name="content"></textarea>
		</div>
		<button>게시글등록</button>
	</form>

</body>
</html>