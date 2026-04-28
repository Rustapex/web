<%@page import="notice.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
</head>
<body>
<%
	ArrayList<Notice> list =(ArrayList<Notice>) request.getAttribute("noticeList");
	
%>

<p>최신 공지 5개</p>


<%
	if(list !=null && list.size() !=0){
%>
		<table>
		<tr>
			<th>아이디</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
<%
		for(Notice notice : list){
			
		
%>
	<tr>
		<td><%=notice.getNotice_id()%></td>
		<td><%=notice.getTitle()%></td>
		<td><%=notice.getDate()%></td>
	</tr>
<%	
		}
	
%>

</table>

<%
	} else{
%>
	<p>데이터가 없습니다.</p>

<%		
	}
%>

</body>
</html>