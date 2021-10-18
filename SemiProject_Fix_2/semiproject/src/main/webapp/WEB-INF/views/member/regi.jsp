<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 회원가입 데이터를 입력하는 페이지 -->    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
    a { text-decoration: none; color: black; }
    a:visited { text-decoration: none; }
    a:hover { text-decoration: none; }
    a:focus { text-decoration: none; }
    a:hover, a:active { text-decoration: none; }
</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body style="background-color:#D8D8D8">

<div align="center">
	    <h1><a href="main.do" style="text-decoration: none">Our Own Trip</a></h1>
</div> 

<br>

<h2 align="center">회원가입</h2>

<br>

<div class="center">

<form action="regiAf.do" method="post"> <!-- 회원가입 버튼이 누르고 정상적으로 회원가입이 성공하면 POST 방식을 사용하여 regiAf.jsp로 이동 -->

<div align="center">

<table border="1" width="600" height="200" >
<tr>
	<th>ID</th>
	<td align="center">
		<input type="text" name="id" id="id" size="20"><br>
		<p id="idcheck" style="font-size: 8px"></p>
		<input type="button" id="btn" value="id확인">
	</td>
</tr>
<tr>
	<th>비밀번호</th>
	<td align="center">
		<input type="password" name="pwd" id="pwd" size="20">
	</td>
</tr>
<tr>
	<th>비밀번호 확인</th>
	<td align="center">
		<input type="password" name="pwcheck" id="pwcheck" size="20"><br>
		<p id="pwdcheck" style="font-size: 8px"></p>
		<input type="button" onclick="check()" value="비밀번호 확인">
	</td>
</tr>
<tr>
	<th>이름</th>
	<td align="center">
		<input type="text" name="name" size="20">
	</td>
</tr>
<tr>
	<th>이메일</th>
	<td align="center">
		<input type="text" name="email" size="20">
	</td>
</tr>
<tr>
	<th>성별</th>
	<td align="center">
		<input type="radio" name="gender" value="남성" size="20">남성
		<input type="radio" name="gender" value="여성" size="20">여성
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
	    <input type="button" onclick="relogin()" value="로그인으로 돌아가기">
		<input type="submit" value="회원가입">
	</td>
</tr>

</table>

</div>
</form>
</div>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btn").click(function () {
		
		$.ajax({ // AJAX는 HTML 페이지 전체가 아닌 일부분만 갱신할 수 있도록 XMLHttpRequest객체를 통해 서버에 request한다. 
			     // 이 경우, JSON이나 XML형태로 필요한 데이터만 받아 갱신하기 때문에 그만큼의 자원과 시간을 아낄 수 있다.
			url:"idcheck.do", // idcheck.do로 데이터를 전송하고 다시 데이터를 받아옴.
			type:"post",
			data:{ id:$("#id").val() }, // 데이터값을 전송, 입력한 아이디값을 전송
			success:function(resp){ // 받아온 데이터값 resp
			//	alert('success');
			//	alert(resp.msg.trim());
			//    alert(resp);
				
				if(resp == "YES"){ // 받아온 데이터값(공백을 제거한) resp가 "YES"라면 사용한 아이디라고 출력 
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html("이 ID는 사용할 수 있습니다");
				}
				else{ // 받아온 데이터값(공백을 제거한) resp가 "NO"라면 사용중인 아이디라고 출력
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html("사용 중인 ID입니다");
					$("#id").val("");
					$("#id").focus();
				}
			},
			error:function(){
				alert('error');
			}
		});
		
	});
	
});

</script>

<script type="text/javascript">
function check() {
	let pwd = document.getElementById("pwd").value;
	let pwcheck = document.getElementById("pwcheck").value;
	
	if(pwd == pwcheck){
		$("#pwdcheck").css("color", "#0000ff");
		$("#pwdcheck").html("비밀번호와 일치합니다!");
	}else{
		$("#pwdcheck").css("color", "#ff0000");
		$("#pwdcheck").html("비밀번호가 일치하지 않습니다.");
		$("#pwcheck").val("");
		$("#pwcheck").focus();
	}
}

</script>

<script type="text/javascript">
function relogin() {
	location.href = "login.do";
}
</script>


</body>
</html>

