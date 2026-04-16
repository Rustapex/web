<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 10까지의 합  -->

<!-- jsp 내장 객체  request(입력), response, out(출력)  -->
<%
	int sum=0;
	for(int i=1; i<=10; i++){
		sum+=i;
	}
	
	out.println(sum);


%>

</body>
</html>