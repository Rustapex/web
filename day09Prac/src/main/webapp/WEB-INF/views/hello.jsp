<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정상처리</title>
</head>
<body>
<%
	int cnt = (int) request.getAttribute("cnt");
	
%>
<h2> 정상처리 </h2>
<%=cnt%>
${cnt}

</body>
</html>