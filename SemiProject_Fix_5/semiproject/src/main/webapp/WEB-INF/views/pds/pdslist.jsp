<%@page import="our.own.trip.dto.MemberDto"%>
<%@page import="our.own.trip.dto.PdsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
  List<PdsDto> list = (List<PdsDto>)request.getAttribute("pdslist");
%>    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역 홍보 게시판</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">

<style>
    a { text-decoration: none; color: black; }
    a:visited { text-decoration: none; }
    a:hover { text-decoration: none; }
    a:focus { text-decoration: none; }
    a:hover, a:active { text-decoration: none; }
</style>

</head>

<body style="background-color:#D8D8D8">

<div class="container text-center" align="center">
	    <h1><a href="main.do" style="text-decoration: none">Our Own Trip</a></h1>
        <br>
        <h2><a href="pdslist.do" style="text-decoration: none">지역 홍보 게시판</a></h2>
</div>

<div align="center">
<table class="type02" border="1">
<col width="70px"><col width="500px"><col width="70px"><col width="70px">
<col width="100px">

<thead>
<tr>
   <th>번호</th><th>제목</th><th>조회수</th><th>다운수</th>
   <th>작성일</th><th>작성자</th>
</tr>
</thead>



<tbody>
<%
     if(list.size() ==0) {
    	 %>
    	 		<tr>
					<td colspan="6">작성된 글이 없습니다.</td>
				</tr>
<%
    
     }

%>
    <%
   for(int i = 0;i < list.size(); i++) {
      PdsDto pds = list.get(i);
    %>
    <tr>
         <th><%=i + 1 %></th>   
         <td>
           <a href="pdsdetail.do?seq=<%=pds.getSeq() %>"> 
              <%=pds.getTitle() %>
           </a>
         </td>
		 <td><%=pds.getReadcount() %></td>
	     <td><%=pds.getDowncount() %></td> 
		 <td><%=pds.getRegdate() %></td>
		 <td><%=pds.getId() %></td>     
    </tr>
     
    <%
       }
        %>
</tbody>
</table>
</div>
<br>

<% 
MemberDto mem = (MemberDto)session.getAttribute("login"); 
if(mem != null && mem.getAuth() == 0){ // 관리자일때만
%>
   <br>   
   <div align="center">
   <button type="button" onclick="pdsAdd()">홍보자료추가</button>
   </div>
<%
}
%>
<!-- 자료 추가 -->
<!-- <button type="button" onclick="pdsAdd()">홍보자료추가</button> -->


<script type="text/javascript">
function pdsAdd() {
//	alert('pdsAdd()');
	location.href = "pdswrite.do";
}

</script>

</body>
</html>