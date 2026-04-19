<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hotel.mvc.HotelCustomer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <style>
 table{
 border:1px solid black;
 margin:0 auto;
 width: 400px;
 margin:0 auto;
 border-collapse: collapse;
 }
 
 td{
 border:1px solid black;
 text-align: center;
 }
 </style>
<body>
<%
HotelCustomer hc = (HotelCustomer) request.getAttribute("hc");
if (hc == null) {
%>
<h3>조회된 고객 정보가 없습니다.</h3>
<%
    return;
}
%>
<form name="frm" action="/day03Prac/update" method="post">
	<table>	
	<tr>
	<td>아이디</td>
	<td> <input type="text" name="customer_id" value="<%=hc.getCustomer_id()%>" readonly></td>
	</tr>
	
	<tr>
	<td>이름</td>
	<td><input type="text"  name="name"  value="<%=hc.getName()%>"></td>
	</tr>
	
	
	<tr>
	<td>전화번호</td>
	<td><input type="text"  name="tel"  value="<%=hc.getTel()%>"></td>
	</tr>
	
	
	<tr>
	<td colspan="2"> 
	 <button>변경</button>
	</td>
	 
	</tr>
	
	</table>

</form>
</body>
</html>