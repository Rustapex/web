<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	int kor = (Integer)request.getAttribute("kor") ;

%>

<%=kor %>

<br>
<h2> EL 은 저장소의 값만 사용할 수 있다.</h2>

<ul>
	<li>pageContext : jsp 페이지 내에서만 사용하는 저장소 - EL, JSTL 사용을 위해서</li>
	<li>request : 하나의 요청이 공유하는 저장소 : 응답되면 종료 - mvc 패턴에서 사용하는 저장소</li>
	<li>session : 하나의 사용자가 공유하는 저장소, 서버가 사용자 별로 저장소를 제공함 </li>
	<li>application : 하나의 프로젝트, 하나의 웹 프로그램이 공유하며 사용하는 저장소 - 설정정보 저장하고 사용함 </li>
</ul>

<h2> 저장소 값 꺼내는 순서, 찾는 순서 </h2>
<h2> pageContext -> request -> session -> application 순으로 찾는다.</h2>

<%
	pageContext.setAttribute("id", "id pageContext");
	request.setAttribute("id", "id request");
	session.setAttribute("id", "id session");
	application.setAttribute("id", "id application"); %>
	
	<h3> el로 id 인 값을 꺼내온다면 </h3>
	
${id}

<p>답은 id pageContext : 이유는 pageContext -> request -> session -> application 순</p>

<h2>저장소에서 값을 꺼내올 때 scope를 지정할 수 있다.</h2>

${pageScope.id} <br>
${requestScope.id} <br>
${sessionScope.id} <br>
${applicationScope.id } <br>

<h3> pageContext 저장소는 EL/JSTL을 사용하기 위해서 이용함</h3>

<%
	String str= "EL 가능?";

%>

${str}

<p>NONO</p>

<% pageContext.setAttribute("str", str); %>

${str }

<%
	if(kor >= 90){
%>
	장학생

<%		
	}
%>

</body>
</html>