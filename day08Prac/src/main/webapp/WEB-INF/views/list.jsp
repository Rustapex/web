<%@page import="page.PagingHandler"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Member.Member"%>
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
  ArrayList<Member> list  = ( ArrayList<Member>)  request.getAttribute("list"); 
	PagingHandler handler = (PagingHandler) request.getAttribute("handler");
%>


<table>
<tr>
<td></td>
<td></td>
</tr>

<% for(  Member  member: list){ %>
 <tr>
<td> <%=member.getM_id() %></td>
<td> <%=member.getM_pw() %></td>
</tr>

<%} %>
</table>

<!-- 이전  -->

<%
	if(handler.getCurrentGrp() >1){  //이전 %>
		<a href="/day08Prac/listpage?p=<%=handler.getGrpStartPage()-1%>">[이전]</a>
<% 	}
%>




<!--페이지네이션 정보 출력하기  -->
<% for (int i = handler.getGrpStartPage(); i <= handler.getGrpEndPage(); i++) { %>

    <% if (i == handler.getCurrentPage()) { %>
        <strong>[<%=i %>]</strong>
    <% } else { %>
        <a href="/day08Prac/listpage?p=<%=i%>">[<%=i %>]</a>
    <% } %>

<% } %>


<!-- 다음 -->

<%
	if(handler.getGrpEndPage() < handler.getTotalPage()){
%>
	<a href="/day08Prac/listpage?p=<%=handler.getGrpEndPage()+1%>">[다음]</a>
<%		
	}
%>

</body>
</html>