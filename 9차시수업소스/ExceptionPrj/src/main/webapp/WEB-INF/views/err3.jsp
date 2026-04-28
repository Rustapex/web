<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>@@@@@@@@서버 오류@@@@@@@@</title>
</head>
<body>

<h2>서버 오류입니다. <br> 관리자에게 문의하세요</h2>

<%
	Integer code=	(Integer) request.getAttribute("javax.servlet.error.status_code");
	String message=	(String) request.getAttribute("javax.servlet.error.message");
	String uri=	(String) request.getAttribute("javax.servlet.error.request_uri");
%>

<p>code : <%=code%></p><br>
<p>message : <%=message%></p><br>
<p>uri : <%=uri%></p><br>


</body>
</html>