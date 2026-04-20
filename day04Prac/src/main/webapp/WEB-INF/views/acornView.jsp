<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="day04Prac.Acorn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acorn 목록</title>
<style>
    table{
        border:1px solid black;
        width:800px;
        margin:20px auto;
        border-collapse:collapse;
        text-align:center;
    }
    th, td{
        border:1px solid black;
        padding:10px;
    }
    .top-box{
        width:800px;
        margin:20px auto;
        text-align:right;
    }
    a{
        text-decoration:none;
    }
</style>
</head>
<body>

<%
    ArrayList<Acorn> list = (ArrayList<Acorn>) request.getAttribute("list");
    String path = request.getContextPath();
%>

<div class="top-box">
    <a href="<%=path%>/reg">회원 등록</a>
</div>

<table>
    <tr>
        <th>이름</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>포인트</th>
        <th>생일</th>
        <th>기능</th>
    </tr>

    <% for(Acorn acorn : list){ %>
    <tr>
        <td><%=acorn.getName()%></td>
        <td><%=acorn.getId()%></td>
        <td><%=acorn.getPw()%></td>
        <td><%=acorn.getPoint()%></td>
        <td><%=acorn.getBirth()%></td>
        <td>
            <a href="<%=path%>/detail?id=<%=acorn.getId()%>">상세</a>
            /
            <a href="<%=path%>/edit?id=<%=acorn.getId()%>">수정</a>
            /
            <a href="<%=path%>/delete?id=<%=acorn.getId()%>"
               onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>