<%@page import="hotel.mvc.RoomGrade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>

<%
	ArrayList <RoomGrade> list = (ArrayList<RoomGrade>) request.getAttribute("list");
	String path = request.getContextPath(); // /day03Prac/ 이거랑 같은 말임
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방 등급 목록</title>
</head>
<body>
<h2>방 등급 목록</h2>

<div class="top-box">
	<a href="<%=path %>/roomgrade/regForm">방 등록</a>
</div>

<% 
	if(list == null || list.isEmpty()){
%>		
		<p>조회된 방 등급이 없습니다.</p>
<% 
	return;
	}
%>	
	

<table border = "1">
	<tr>
		<td>방 등급번호</td>
		<td>방 이름</td>
		<td>가격</td>
		<td>호텔 아이디</td>
		<td>기능</td>
	</tr>
	<%for(RoomGrade rg : list){ %>
	<tr>
		<td><%=rg.getRoomgrade_num()%></td>
		<td><%=rg.getRoom_name()%></td>
		<td><%=rg.getPrice()%></td>
		<td><%=rg.getHotel_id()%></td>
		
		<td>
			<a href="<%=path%>/roomgrade/one?roomgrade_num=<%=rg.getRoomgrade_num()%>">수정</a> /
			<a href="<%=path%>/roomgrade/delete?roomgrade_num=<%=rg.getRoomgrade_num()%>">삭제</a> /
			
		</td>
	</tr>
	<%} %>
</table>

</body>
</html>