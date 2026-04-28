<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회 선택 화면</title>
</head>
<% 
	String path = request.getContextPath();
%>
<body>
	<a href="<%=path%>/book/list">아이디순</a>
	<a href="<%=path%>/book/list?sort=title">제목순</a>
	<a href="<%=path%>/book/list?sort=price">가격순</a>
	<a href="<%=path%>/book/list?sort=stock">재고순</a>

</body>
</html>