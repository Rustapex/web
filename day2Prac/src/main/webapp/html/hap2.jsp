<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border: 2px solid red;
		width: 500px;
	}

</style>
</head>

<table>
	<tr>
		<td>1</td>
		<td>2</td>
		<td>3</td>
		<td>4</td>
		<td>5</td>
	</tr>
	<tr>
		<td>11</td>
		<td>12</td>
		<td>13</td>
		<td>14</td>
		<td>15</td>
	</tr>
</table>


<h2>사용자가 입력한 수 까지의 합 구하기</h2>

<%
	int num1 = Integer.parseInt(request.getParameter("num"));

	int sum=0;
	for(int i=0; i<= num1; i++){
		sum+= i;
	}
	out.println(sum);

%>
<p>
<%= sum %>
</p>

<body>
<%




%>

</body>
</html>