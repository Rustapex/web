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

<!-- var : 변수 , 변수는 자동으로 pageContext 에 저장됨, 그래서 EL 문법 사용 가능  -->


<table>

	<tr>
		<th>영화제목</th>
	</tr>

<c:forEach var="item" items="${movies}">

	<tr>
		<td>${item}</td>
	</tr>
</c:forEach>
</table>

	


</body>
</html>