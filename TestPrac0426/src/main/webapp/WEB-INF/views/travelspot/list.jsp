<%@page import="travelSpot.Travelspot"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 지역</title>
</head>
<body>
<%
	ArrayList<Travelspot> list = (ArrayList<Travelspot>) request.getAttribute("list");
	if(list != null) {
%>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>지역</th>
	</tr>
<%
		for(Travelspot ts : list) {
%>
	<tr>
		<td><%=ts.getSpotId()%></td>
		<td><%=ts.getSpotName()%></td>
		<td><%=ts.getRegion()%></td>
	</tr>
<%
		}
	} else {
%>
	<p>데이터가 없습니다.</p>
<%	
	} 
%>

</table>

</body>
</html>