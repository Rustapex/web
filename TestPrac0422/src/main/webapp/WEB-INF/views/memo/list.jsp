<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="memo.Memo" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	
	td, th{
		border : 1px solid red;
	}
</style>
<body>

<% 
	ArrayList<Memo> list = new ArrayList<>();
	list = (ArrayList<Memo>) request.getAttribute("list");
	String path = request.getContextPath();
%>

<h2> 메모장</h2>
<table>

	<tr>
		<th>메모 아이디</th>
		<th>내용</th>
		
	</tr>
	<%
		if(list != null){
			for(Memo m : list){
	%>
	<tr>
		<td><%=m.getMemoId()%></td>
		<td><%=m.getContent()%></td>
		
	</tr>

<%} } %>

</table>



</body>
</html>