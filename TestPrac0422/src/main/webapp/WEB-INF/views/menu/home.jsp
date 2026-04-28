<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="menu.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<body>

<% 
	ArrayList<Menu> list = (ArrayList<Menu>) request.getAttribute("list"); 
	String path = request.getContextPath();
%>

<h2>메뉴</h2>

<table border = "1">
	<tr>
		<th>메뉴 아이디</th>
		<th>메뉴이름</th>
	</tr>	
	<%
		if(list != null){
			for(Menu menu : list){ 
	%>
	<tr>
		<td><%=menu.getMenuId()%></td>
		<td><%=menu.getMenuName()%></td>
	</tr>
	<%
			} 
		}
	%>
</table>

</body>
</html>