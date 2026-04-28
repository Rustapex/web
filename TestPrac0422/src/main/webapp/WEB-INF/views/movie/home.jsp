<%@page import="movie.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Movie> list = (ArrayList<Movie>) request.getAttribute("list");
	if(list == null || list.size() ==0 ){ 
%>
	<h2>목록이 없습니다.</h2>	
<%
	} else {
%>
	<h2>영화 목록</h2>

<table>
	<tr>
		<th>영화 아이디</th>
		<th>영화 제목</th>
	</tr>
<% 
	for(Movie movie : list){
%>
	<tr>
		<td><%=movie.getMovieId()%></td>
		<td><%=movie.getTitle()%></td>
	</tr>
	
<% 
	}
%>
	
</table>
<%
	}
%>

</body>
</html>