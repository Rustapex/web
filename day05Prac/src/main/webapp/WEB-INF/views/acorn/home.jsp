<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acorn HOME</title>
</head>
<body>

<%
	String path = request.getContextPath();   // 예: /day05Prac
%>

<img src ="/day05Prac/imgs/a.jpg">

<h2>에이콘 학생 관리</h2>

<ul>
	<li><a href="<%=path%>/acorn/list">학생 전체 조회</a></li>
	<li><a href="<%=path%>/acorn/reg">학생 등록</a></li>
	
	<h3>학생 한 명 조회 / 변경</h3>
	<form action="<%=path%>/acorn/detail" method="get">
		<input type="text" name="id" placeholder="조회할 아이디">
		<button type="submit">학생 한 명 조회</button>
	</form>
	<h3>학생 탈퇴</h3>
	<form action="<%=path%>/acorn/delete" method="post">
		<input type="text" name="id" placeholder="삭제할 아이디">
		<button type="submit">학생 탈퇴</button>
	</form>
</ul>

</body>
</html>