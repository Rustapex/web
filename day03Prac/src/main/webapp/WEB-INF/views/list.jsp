<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="hotel.mvc.HotelCustomer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/day03Prac/css/list.css"  type="text/css"  rel="stylesheet" >
<style>
.btn-wrap{
    width:300px;
    margin:20px auto;
    text-align:center;
}
</style>
</head>
<body>

<table>

<caption>호텔 고객 목록</caption>

<div class="btn-wrap">
    <a href="<%=request.getContextPath()%>/regForm">고객 등록</a>
</div>

<tr>
<td>아이디 </td>
<td>이름 </td>
<td>전화번호 </td>
<td> 삭제 / 변경  </td>
</tr>
<%
ArrayList<HotelCustomer> list = (ArrayList<HotelCustomer>) request.getAttribute("list");
if(list == null || list.isEmpty()){
%>
    <h3>고객 목록이 없습니다.</h3>
<%
    return;
}
for(HotelCustomer hc : list){
%>

		<tr>
		<td><%=hc.getCustomer_id() %> </td>
		<td><%=hc.getName() %> </td>
		<td><%=hc.getTel() %> </td>
		<td> <a href="/day03Prac/delete?customer_id=<%=hc.getCustomer_id()%>">삭제</a> /
<a href="/day03Prac/hotelCustomer?customer_id=<%=hc.getCustomer_id()%>">변경</a> </td>
		</tr>

<%} %>
</table>

</body>
</html>