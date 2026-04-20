<%@page import="hotel.mvc.RoomGrade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList <RoomGrade> list = (ArrayList<RoomGrade>) request.getAttribute("list");
	String path = request.getContextPath(); // /day03Prac/ 이거랑 같은 말임
%>

<div class="top-box">
	<a href="<%=path %>/roomgrade/list">방 등록</a>
</div>

<table>
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
			<a href="<%=path%>/roomgrade/update?roomgrade_num=<%=rg.getRoomgrade_num()%>">수정</a> /
			<a href="<%=path%>/roomgrade/delete?roomgrade_num=<%=rg.getRoomgrade_num()%>">삭제</a> /
			
		</td>
	</tr>
	<%} %>
</table>

</body>
</html>