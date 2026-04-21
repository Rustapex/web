<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String path = request.getContextPath();
%>

	<h2>에이콘 학생 등록하기</h2>
	<form action="<%=path%>/acorn/reg" method="post">  
	<input type="text" name="id" placeholder="아이디">
	<input type="text" name="name" placeholder="이름">
	<input type="text" name="pw" placeholder="비밀번호">
	<input type="text" name="point" placeholder="포인트">
	<input type="date" name="birth">
	<button type="submit">등록</button>
</form>

</body>
</html>