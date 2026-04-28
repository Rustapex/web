<%@page import="book.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회 결과</title>
</head>
<body>
<%
	ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("list");
	String path = request.getContextPath();
%>
<% 
if(list != null && list.size() != 0){
%>
<table border= "1">
	<tr>
		<th>책 아이디</th>
		<th>제목</th>
		<th>저자</th>
		<th>가격</th>
		<th>재고</th>
	</tr>
	
<%
	for(Book book : list){
%>
	
	<tr>
		<td><%=book.getBookId()%></td>
		<td><%=book.getTitle()%></td>
		<td><%=book.getAuthor()%></td>
		<td><%=book.getPrice()%></td>
		<td><%=book.getStock()%></td>
	</tr>
	
<%		
	}
%>
</table>
<%
} else{
%>
	<p>데이터가 없습니다</p>
<%
}
%>
<a href="<%=path%>/index.jsp">처음으로</a>



</body>
</html>