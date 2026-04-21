<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="day05Prac.dto.Acorn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 상세조회</title>
<style>
table{
	border:1px solid black;
	margin:0 auto;
	width:400px;
	border-collapse:collapse;
}
td{
	border:1px solid black;
	text-align:center;
	padding:8px;
}
h2{
	text-align:center;
}
.menu{
	text-align:center;
	margin-top:15px;
}
</style>
</head>
<body>

<%
	String path = request.getContextPath();
	Acorn acorn = (Acorn) request.getAttribute("acorn");
	if(acorn == null){
%>
	<h3 style="text-align:center;">조회된 고객 정보가 없습니다.</h3>
<%
	}else{
%>

<h2>학생 상세조회</h2>

<table>
	<tr>
		<td>아이디</td>
		<td><%=acorn.getId()%></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=acorn.getName()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=acorn.getPw()%></td>
	</tr>
	<tr>
		<td>포인트</td>
		<td><%=acorn.getPoint()%></td>
	</tr>
	<tr>
		<td>생일</td>
		<td><%=acorn.getBirth()%></td>
	</tr>
</table>

<div class="menu">
	<a href="<%=path%>/acorn/update?id=<%=acorn.getId()%>">수정하기</a>
	<a href="<%=path%>/acorn/list">목록으로</a>
</div>

<%
	}
%>

</body>
</html>