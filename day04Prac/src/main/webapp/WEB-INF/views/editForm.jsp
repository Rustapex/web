<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="day04Prac.Acorn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
<style>
    .wrap{
        width:400px;
        margin:50px auto;
    }
    input{
        width:100%;
        padding:8px;
        margin-bottom:10px;
        box-sizing:border-box;
    }
    button{
        padding:8px 16px;
    }
</style>
</head>
<body>

<%
    Acorn acorn = (Acorn) request.getAttribute("acorn");
    String path = request.getContextPath();
%>

<div class="wrap">
    <h2>회원 수정</h2>

    <form method="post" action="<%=path%>/edit">
        아이디
        <input type="text" name="id" value="<%=acorn.getId()%>" readonly>

        비밀번호
        <input type="text" name="pw" value="<%=acorn.getPw()%>">

        포인트
        <input type="text" name="point" value="<%=acorn.getPoint()%>">

        <button type="submit">수정하기</button>
        <a href="<%=path%>/detail?id=<%=acorn.getId()%>">취소</a>
    </form>
</div>

</body>
</html>