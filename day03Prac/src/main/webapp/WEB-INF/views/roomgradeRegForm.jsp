<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방 등급 등록</title>
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
	let roomgradeNum  = frm.roomgrade_num.value.trim();
	let roomName  = frm.room_name.vale.trim();
	let hotelId  = frm.hotel_id.value;
	
	if( roomgradeNum==""){
		alert("방 등급 번호를 입력하세요.");
		frm.customer_Id.focus();
		return false;
	}
	
	if( roomName==""){
		alert("이름을 입력하세요");
		frm.name.focus();
		return false;
	}
	
	if( hotelId==""){
		alert("호텔 아이디 입력");
		frm.tel.focus();
		return false;
	}
	
	if(!roomgradeNum.startsWith("rg")){
		alert("등급번호는 rg로 시작해야 합니다.");
		frm.customer_id.focus();
		return false;
	}
	
	
	return true;
	
	
}

</script>
</head>
<body>
<form></form>

</body>
</html>