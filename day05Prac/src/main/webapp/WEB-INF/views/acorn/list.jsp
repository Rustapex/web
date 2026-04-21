<%@page import="day05Prac.dto.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 목록</title>
<style>
table{
	border:1px solid black;
	margin:0 auto;
	border-collapse:collapse;
}
td, th{
	border:1px solid black;
	padding:8px;
	text-align:center;
}
h2{
	text-align:center;
}
.inline-form{
	display:inline;
	margin:0;
}
</style>
</head>
<body>

<%
	String path = request.getContextPath();
	ArrayList<Acorn> list = (ArrayList<Acorn>)request.getAttribute("list");
%>

<h2>에이콘 학생 명단</h2>

<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>비번</th>
		<th>포인트</th>
		<th>생일</th>
		<th>상세조회</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>

<%
if(list != null){
	for(Acorn acorn : list){
%>
	<tr>
		<td><%=acorn.getId()%></td>
		<td><%=acorn.getName()%></td>
		<td><%=acorn.getPw()%></td>
		<td><%=acorn.getPoint()%></td>
		<td><%=acorn.getBirth()%></td>
		<td><a href="<%=path%>/acorn/detail?id=<%=acorn.getId()%>">상세조회</a></td>
		<td><a href="<%=path%>/acorn/update?id=<%=acorn.getId()%>">수정</a></td>
		<td>
			<form class="inline-form" action="<%=path%>/acorn/delete" method="post">
				<input type="hidden" name="id" value="<%=acorn.getId()%>">
				<button type="submit">삭제</button>
			</form>
		</td>
	</tr>
<%
	}
}
%>
</table>

</body>
</html>