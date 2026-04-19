<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호텔 고객 등록</title>
<style>
table{
	border:1px solid black;
	width:300px;
	margin:100px auto;
	border-collapse: collapse;
}

td{
border:1px solid black;
text-align: center;
}
</style>
<script>
function regCheck(){
	let frm = document.frm;
	let customerId  = frm.customer_Id.value.trim();
	let name  = frm.name.vale.trim();
	let tel  = frm.tel.value;
	
	if( customerId==""){
		alert("아이디 입력하세요.");
		frm.customer_Id.focus();
		return false;
	}
	
	if( name==""){
		alert("이름을 입력하세요");
		frm.name.focus();
		return false;
	}
	
	if( tel==""){
		alert("전화번호 입력");
		frm.tel.focus();
		return false;
	}
	
	if(!customerId.startsWith("c")){
		alert("아이디는 c로 시작해야 합니다.");
		frm.customer_id.focus();
		return false;
	}
	
	
	return true;
	
	
}

</script>
</head>
<body>
<form name="frm" action="<%=request.getContextPath()%>/reg" method="post" onsubmit="return regCheck()">
<table>
	<caption>호텔 고객등록</caption>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="customer_id" placeholder="c로 시작하는 아이디"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name"></td>
	</tr>

	<tr>
		<td>전화번호</td>
		<td><input type="text" name="tel"></td>
	</tr>

	<tr>
		<td colspan="2">
			<button type="submit">등록</button>
			<button type="reset">취소</button>
		</td>
	</tr>
</table>
</form>

</body>
</html>