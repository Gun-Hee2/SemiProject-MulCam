<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 회원가입 데이터를 입력하는 페이지 -->    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>

*{
  text-decoration:none; 
  box-sizing : border-box;
}

body {
   margin: 0;
}


.login-form {
    width: 400px;
    background: #EEEFF1;
    margin-left: auto;
    margin-right: auto;
    margin-top: 10px;
    border-radius: 5px;
    padding: 30px;
}
.text-field {
    font-size: 14px;
    width: 70%;
    border: none;
    border-radius: 5px;
    padding: 10px;
    margin-bottom: 20px;
}
.form-check mb-0 {
font-size: 14px;
}
.submit-btn {
    font-size: 14px;
    background-color: #1BBC9B;
    color: white;
    width: 100%;
    border-radius: 5px;
    border: none;
    padding: 10px;
    margin-top: 20px;
    margin-bottom: 20px;
}

.check-btn {
    font-size: 14px;
    background-color:#1BBC9B;
    color: white;
    width: 25%;
    border-radius: 5px;
    border: none;
    padding: 8px;
    margin: 5px;
}
.links {
    text-align: center;
}

.links a {
    font-size: 12px;
    color:  #9B9B9B;
    text-decoration-line: underline;
}
</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body style="background-color:white;">

<div align="center" class="header">
	    <h1 style="margin-top: 0px; padding: 10px"><a href="main.do" style="text-decoration: none; color: black;">Our Own Trip</a></h1>
</div> 

<br>



<br>
<div class="login-form">
<!-- 회원가입 버튼이 누르고 정상적으로 회원가입이 성공하면 POST 방식을 사용하여 regiAf.jsp로 이동 -->

<form action="regiAf.do" method="post">
  <h2 align="center" style="margin-top: 0px; margin-bottom: 40px">회원가입</h2>
  
  
  	<input type="text" id="id" name="id" class="text-field" size="20" style="margin-bottom: 0px;" placeholder="아이디">
	<input type="button" id="btn" class="check-btn" value="확인"><br>
		<p id="idcheck" style="font-size: 8px; margin: 10px; margin-top: 0px; padding: 5px"></p>
		
		

	 <input type="password" name="pwd" class="text-field" id="pwd" size="20" placeholder="비밀번호">
	 
	 <input type="password" name="pwcheck" class="text-field" id="pwcheck" style="margin-bottom: 0px;" size="20" placeholder="비밀번호 확인">
	<input type="button" onclick="check()" class="check-btn" value="확인"><br>
		<p id="pwdcheck" style="font-size: 8px; margin: 10px; margin-top: 0px; padding: 5px" ></p>
		

		<input type="text" name="name" class="text-field" size="20" placeholder="이름">

	<input type="text" name="email" class="text-field" size="20" placeholder="이메일"><br>


	<th>성별 :</th>

		<input type="radio" name="gender" value="남성" size="20">남성
		<input type="radio" name="gender" value="여성" size="20">여성 <br>
		
		<div align="center">
		<input type="submit" class="submit-btn" value="회원가입">
		<div class="links">
		<a href="#" onclick="relogin()">로그인으로 돌아가기</a>
		
	    </div>

  </form>
    </div>

<!-- 

		<input type="submit" value="회원가입">
	</td>
</tr>

</table> -->



<script type="text/javascript">

function relogin() { 
	location.href = "login.do";
}

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
		$("#pwdcheck").html("입력한 비밀번호와 일치합니다!");
	}else{
		$("#pwdcheck").css("color", "#ff0000");
		$("#pwdcheck").html("입력한 비밀번호와 일치하지 않습니다.");
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

