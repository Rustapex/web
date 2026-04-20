<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="day04Prac.Acorn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세조회</title>
<style>
    table{
        width:500px;
        margin:40px auto;
        border-collapse:collapse;
    }
    th, td{
        border:1px solid black;
        padding:10px;
    }
    .btns{
        width:500px;
        margin:20px auto;
        text-align:center;
    }
</style>
</head>
<body>

<%
    Acorn acorn = (Acorn) request.getAttribute("acorn");
    String path = request.getContextPath();
%>

<table>
    <tr><th>아이디</th><td><%=acorn.getId()%></td></tr>
    <tr><th>이름</th><td><%=acorn.getName()%></td></tr>
    <tr><th>비밀번호</th><td><%=acorn.getPw()%></td></tr>
    <tr><th>포인트</th><td><%=acorn.getPoint()%></td></tr>
    <tr><th>생일</th><td><%=acorn.getBirth()%></td></tr>
</table>

<div class="btns">
    <a href="<%=path%>/edit?id=<%=acorn.getId()%>">수정</a>
    /
    <a href="<%=path%>/delete?id=<%=acorn.getId()%>"
       onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
    /
    <a href="<%=path%>/acorn">목록</a>
</div>

</body>
</html>