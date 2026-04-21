<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="day05Prac.dto.Acorn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
</head>
<body>

<%
	String path = request.getContextPath();
	Acorn acorn = (Acorn)request.getAttribute("acorn");
	if(acorn == null){
%>
	<h3>조회된 고객 정보가 없습니다.</h3>
<%
	}else{
%>

<h2>학생 정보 수정</h2>

<form action="<%=path%>/acorn/update" method="post">
	<input type="text" name="id" value="<%=acorn.getId()%>" readonly="readonly">
	<input type="text" name="name" value="<%=acorn.getName()%>" readonly="readonly">
	<input type="text" name="pw" value="<%=acorn.getPw()%>">
	<input type="text" name="point" value="<%=acorn.getPoint()%>">
	<input type="text" name="birth" value="<%=acorn.getBirth()%>" readonly="readonly">
	<button type="submit">변경</button>
</form>

<%
	}
%>

</body>
</html>