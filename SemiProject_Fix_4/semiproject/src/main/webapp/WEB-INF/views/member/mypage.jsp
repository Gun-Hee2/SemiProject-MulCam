<%@page import="our.own.trip.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="our.own.trip.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String search = (String)request.getAttribute("reviewsearch");
if(search == null) search = "";

String choice = (String)request.getAttribute("reviewchoice");

int bbsPage = (Integer)request.getAttribute("mypagebbsPage");

int pageNumber = (Integer)request.getAttribute("mypagepageNumber");

List<BbsDto> list = (List<BbsDto>)request.getAttribute("mypagebbslist");

String id = (String)request.getAttribute("id");
%>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<style>
    a { text-decoration: none; color: black; }
    a:visited { text-decoration: none; }
    a:hover { text-decoration: none; }
    a:focus { text-decoration: none; }
    a:hover, a:active { text-decoration: none; }
</style>

</head>

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

<%
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
%>


<body style="background-color:#D8D8D8">

<div class="container text-center" align="center">
	    <h1><a href="main.do" style="text-decoration: none">Our Own Trip</a></h1>
        <br>
        <h2>마이페이지</a></h2>
</div>
<br>

<div class="bottomright" align="center">

  	<table border="1" width="600" height="200">
  	
  	<tr>
  	    <th colspan="2" style="font-size:25px;">환영합니다!&nbsp;&nbsp;&nbsp;<%=mem.getName() %>님</th>
  	</tr>
  	
  	<tr>
  	    <th colspan="2" style="font-size:20px;">아이디: <%=mem.getId() %></th>
  	</tr>
  	
  	<tr>
  	    <th colspan="2" style="font-size:20px;">이메일: <%=mem.getEmail() %></th>
  	</tr>
  	
  	<tr>
  	    <th colspan="2" style="font-size:20px;">성별: <%=mem.getGender()%></th>
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
  	
  	<br><br><br>

 	
<div align="center">
<h2>내가 작성한 게시글</h2> 
<table border="1">
<col width="70px"><col width="500px"><col width="100px">
<tr>
   <th>번호</th><th>제목</th><th>조회수</th>
</tr>

<%
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
               <%-- <a href="sharebbsdetail.do?seq=<%=bbs.getSeq() %>&name=<%=name %>"><%=dot3(bbs.getTitle() ) %></a> --%> 
                <%=dot3(bbs.getTitle() ) %>
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
</div>  	

<script type="text/javascript">

function goPage( pageNum ) {
	   let id = '<%=id %>'; 
	   location.href = "mypage.do?id=" + id + "&pageNumber=" + pageNum;
	}

</script>

</body>
</html>