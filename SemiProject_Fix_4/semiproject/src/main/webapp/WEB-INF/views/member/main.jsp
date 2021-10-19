<%@page import="our.own.trip.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Our Own Trip(우리만의 여행)</title>
<style>
    a { text-decoration: none; color: black; }
    a:visited { text-decoration: none; }
    a:hover { text-decoration: none; }
    a:focus { text-decoration: none; }
    a:hover, a:active { text-decoration: none; }
</style>
</head>
<%
MemberDto mem = (MemberDto)session.getAttribute("login");
System.out.println(mem);
%>
<body style="background-color:#D8D8D8">
<div class="container">	
	<!-- <div style="width: auto; height: 100px"></div> -->	
	<div class="container text-center" align="center">
	    <h1><a href="main.do" style="text-decoration: none">Our Own Trip</a></h1>
	</div>  
  	<!-- <div class="bottomright">환영합니다 <%-- =mem.getId() --%>님 반갑습니다</div> -->
<%
  	if(mem == null){
    %>
  	<div class="bottomright" align="right">
  	<a href="login.do" style="text-decoration: none; font-weight: bold">로그인</a>
  	</div>
  	<%
    }else{
%>
    <div class="bottomright" align="right">
    <%-- <form action="logout.do" method="post">
    <input type="hidden" name="mem" size="50px" value="<%=mem %>" >
    <input type="submit" value="로그아웃">
    </form> --%>
  	<table border="1">
  	<tr>
  	    <th><%=mem.getName() %>님</th><th><a href="mypage.do?id=<%=mem.getId() %>" style="text-decoration: none">내정보</a></th>
  	</tr>
  	
  	<tr>
  	    <td colspan="2">아이디:<%=mem.getId() %></td>
  	</tr>
  	
  	<tr>
  	    <td colspan="2">이메일:<%=mem.getEmail() %></td>
  	</tr>
  	<tr>
  	    <th colspan="2">
  	        <form action="logout.do" method="post">
            <input type="hidden" name="mem" size="50px" value="<%=mem %>" >
            <input type="submit" value="로그아웃">
            </form>
        </th>
  	</tr>
  	
  	</table>
  	</div>
<%
    }
%>
</div> 
<br><br><br>

<jsp:include page="menu.jsp" flush="false"/>

<br><br>

<jsp:include page="mainpicture.jsp" flush="false"/>



</body>
</html>