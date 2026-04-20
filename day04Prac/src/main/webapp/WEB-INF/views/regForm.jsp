<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
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
    String path = request.getContextPath();
%>

<div class="wrap">
    <h2>회원 등록</h2>

    <form method="post" action="<%=path%>/reg">
        <input type="text" name="id" placeholder="아이디">
        <input type="text" name="pw" placeholder="비밀번호">
        <input type="text" name="name" placeholder="이름">
        <input type="text" name="point" placeholder="포인트">
        <button type="submit">등록하기</button>
        <a href="<%=path%>/acorn">목록으로</a>
    </form>
</div>

</body>
</html>