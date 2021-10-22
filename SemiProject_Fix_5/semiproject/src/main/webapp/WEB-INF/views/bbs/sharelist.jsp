<%@page import="our.own.trip.dto.MemberDto"%>
<%@page import="our.own.trip.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String search = (String)request.getAttribute("sharesearch");
if(search == null) search = "";

String choice = (String)request.getAttribute("sharechoice");

int bbsPage = (Integer)request.getAttribute("sharebbsPage");

int pageNumber = (Integer)request.getAttribute("sharepageNumber");

List<BbsDto> list = (List<BbsDto>)request.getAttribute("sharebbslist");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 정보 공유 게시판</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">

<style>
    a { text-decoration: none; color: black; }
    a:visited { text-decoration: none; }
    a:hover { text-decoration: none; }
    a:focus { text-decoration: none; }
    a:hover, a:active { text-decoration: none; }
</style>

<script type="text/javascript">
$(document).ready(function() {
	// 검색어가 있는 경우
	let search = "<%=search %>";
	if(search == "") return;
	
	// select 처리
	let obj = document.getElementById("choice");
	obj.value = "<%=choice %>";
	obj.setAttribute("selected", "selected");	
});
</script>

</head>
<body style="background-color:#D8D8D8">





<%!

// 제목에 문자열의 길이가 30자를 넘을 때 ... 으로 표현
public String dot3(String title) {
   String str = "";
   if(title.length() >= 30){   // 30보다 크거나 같을 때
      str = title.substring(0, 30); // 0 ~ 29
      str += "...";
   } else{
      str = title;      
   }
   return str;
}

%>

<%-- <%
MemberDto mem = (MemberDto)session.getAttribute("login"); 
// 저장했던 키값이 "login"인 세션을 받아와서 MemberDto객체인 mem에 넣는다.

if(mem == null){ // 로그인 정보 세션값이 존재하지 않을 때
%>
   <script type="text/javascript">
   alert("로그인 해 주십시오"); // 다음과 같은 알림창이 출력된다.
   location.href = "login.do"; // 로그인정보의 세션값이 존재하지 않기 때문에 다시 로그인 페이지인 login.jsp로 이동한다.

   </script>
<%
}
%> --%>

<div class="container text-center" align="center">
	    <h1><a href="main.do" style="text-decoration: none">Our Own Trip</a></h1>
        <br>
        <h2><a href="share.do" style="text-decoration: none">여행 정보 공유 게시판</a></h2>
</div>

<div align="center">

<table class="type02" border="1">
<col width="70px"><col width="500px"><col width="100px">
<tr>
   <th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
</tr>

<%
String name = "share";
if(list == null || list.size() == 0){ // 쿼리문을 조회한 값이 담겨있는 리스트가 없거나 리스트가 비어있을 때
%>
   <tr>
      <td colspan="3">작성된 글이 없습니다</td>
   </tr>
<%
}else{ // 쿼리문을 조회한 값이 담겨있는 리스트가 존재할 때
   
   for(int i = 0;i < list.size(); i++){
	   BbsDto bbs = list.get(i); // ArrayList안의 각각의 인덱스번호에 해당되는 데이터들을 차례대로 가져온다.
%>
      <tr>
         <th><%=(i + 1) %></th> <!-- 게시물의 번호, 번호는 1번부터 시작 -->
         <td>
            <%
            if(bbs.getDel() == 0){
               %>
               <%-- <%=arrow( bbs.getDepth() ) %> --%> <!-- 추가되는 답글의 제목앞에 arrow.png그림을 추가하는 메소드 -->
         
               <%-- <%=bbs.getTitle()--%>  <!-- 첫번째 게시물 부터 차례대로 제목을 출력 -->
               <a href="sharebbsdetail.do?seq=<%=bbs.getSeq() %>&name=<%=name %>"><%=dot3(bbs.getTitle() ) %></a> 
                <!-- bbsdetail.jsp로 seq값과 title값(30자가 넘어가는 제목은 점3개로 표시하는 함수에 넣은값)을 가져간다. -->
               <%
            }else{   
               %>
               <font color="#ff0000">***이 글은 작성자에 의해서 삭제되었습니다***</font>
               <%
            }
            %>
            
         </td>
         <td align="center"><%=bbs.getReadcount() %></td>
         <!-- 글들의 REF, STEP과 DEPTH의 값을 나타낸다. -->
         <td align="center">
            <%=bbs.getId() %> <!-- 첫번째 게시물 부터 차례대로 작성자의 id을 출력 -->
         </td>
      </tr>
<%
   }
}
%>

</table>

<br>
<%-- 1 [2] [3] --%>
<%
for(int i = 0; i < bbsPage; i++){
   if(pageNumber == i) {   // 현재 페이지 1 [2] [3]
      %>
      <span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
         <%=i + 1 %>   
      </span>&nbsp;
      <%
   }
   else {                // 현재 페이지를 제외한 페이지들
      %>
      <a href="#none" title="<%=i + 1 %>페이지" onclick="goPage(<%=i %>)"
         style="font-size: 15pt; color: #000; font-weight: bold; text-decoration: none;">
         [<%=i + 1 %>]
      </a>&nbsp;
      <%
   }
}
%>

<br><br>

<br>

<div align="center">

<select id="choice" style="height:25px; vertical-align: middle">
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="id">작성자</option>
</select>

<input type="text" id="search" value="<%=search %>" style="height:20px">

<button type="button" onclick="searchBbs()" style="height:25px; vertical-align: middle">검색</button>

</div>

<% 
MemberDto mem = (MemberDto)session.getAttribute("login"); 
if(mem != null){ // 로그인 정보 세션값이 존재할 때
%>
   <br>   
   <a href="sharebbswrite.do">글쓰기</a> <!-- 글쓰기 링크를 누르면 글을 작성하는 페이지인 bbswrite.jsp로 이동한다. -->
</div>
<%
}
%>

<script type="text/javascript">

function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;

	location.href = "share.do?choice=" + choice + "&search=" + search;
}

function goPage( pageNum ) {
	   let choice = document.getElementById("choice").value; // 선택한 <select>의 value값을 가져온다.
	   let search = document.getElementById("search").value; // 입력한 <input>의 value값을 가져온다.
	   
	   // 검색과 페이징은 같이 가야된다.
	   location.href = "share.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNum;
	}

</script>

</body>
</html>