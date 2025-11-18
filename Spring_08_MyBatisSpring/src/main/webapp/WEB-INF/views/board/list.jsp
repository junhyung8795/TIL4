<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체목록</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<table>

		<c:forEach items="${boardList} var="board">
			<tr>
				<th>${board.id }</th>
				<th><a href="/detail?id=${board.id}">${board.title }</a></th>
				
				<th>${board.writer }</th>
				<th>${board.viewCnt }</th>
				<th>${board.regDate }</th>
			</tr>
		</c:forEach>


	</table>


</body>
</html>