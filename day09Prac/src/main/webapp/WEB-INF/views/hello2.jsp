<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정상 작동</title>
</head>
<body>

<h2>정상 작동</h2>
<% 
	int cnt = (int) request.getAttribute("cnt"); 

%>
${cnt}

</body>
</html>