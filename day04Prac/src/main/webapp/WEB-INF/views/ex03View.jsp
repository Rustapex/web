<%@page import="day04Prac.Score" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href ="/day04Prac/css/ex03.css">
</head>
<body>
ex03View

<% Score score = (Score) request.getAttribute("data");
%>
<%score.getMath(); %>
<%score.getMath(); %>
<%score.getMath(); %>
<%score.getMath(); %>

<table>
	<tr>
		<td>이름</td>
	    <td>국어</td>
		<td>영어</td>
		<td>수학</td>
	</tr>
	<tr>
		<td><%=score.getName() %></td>
	    <td><%=score.getKor() %></td>
		<td><%=score.getEng() %></td>
		<td><%=score.getMath() %></td>
	</tr>
</table>

</body>
</html>