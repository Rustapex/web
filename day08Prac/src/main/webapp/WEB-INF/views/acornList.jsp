<%@page import="java.awt.event.ItemEvent"%>
<%@page import="ELJSTL.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border : 1px solid black;
	}

</style>
</head>
<body>



<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
	</tr>
	
	<c:forEach var="item"  items="${list}">
	<tr>
		<td>${item.id}</td>
		<td>${item.pw}</td>
		<td>${item.name}</td>
	</tr>
		
	</c:forEach>
	


</table>

</body>
</html>