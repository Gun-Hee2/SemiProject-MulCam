<%@page import="our.own.trip.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%>
<h2>홍보 자료 업로드</h2>

<form action="mypdsupload.do" method="post" enctype="multipart/form-data">

<input type="hidden" name="id" value="<%=mem.getId() %>">
<table border="1">
<col width="200"><col width="400">
<tr>
     <th>아이디</th>
     <td><%=mem.getId() %></td>    	
</tr>

<tr>
    <th>제목</th>
    <td><input type="text" name="title" size="80px">
    </td>
</tr>
<tr>
   <th>파일 업로드</th>
   <td>
       <input type="file" name="myfileload">
   </td>
</tr>

<tr>
   <th>내용</th>
   <td>
       <textarea rows="20" cols="100px" name="content"></textarea>
   </td>
</tr>

<tr>
    <td colspan="2">
       <input type="submit" value="자료올리기">
    </td>
</tr>


</table>


</form>
</body>
</html>