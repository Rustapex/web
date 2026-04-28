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
	String travelMsg = (String) session.getAttribute("travelMsg");
%>

<a href="<%=request.getContextPath()%>/travel/list">여행지 리스트 보기</a> 
<br>

<p>메시지 : ${travelMsg}<p>


</body>
</html>