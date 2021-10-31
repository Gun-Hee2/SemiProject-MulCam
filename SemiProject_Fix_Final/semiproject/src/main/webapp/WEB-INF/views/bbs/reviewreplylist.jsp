<%@page import="our.own.trip.dto.BbsReplyDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
List<BbsReplyDto> list = (List<BbsReplyDto>)request.getAttribute("list");
System.out.println(list);

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- <h2 align="center">SHARE REPLY LIST</h2> -->

<div align="center">

<table border="1">
<col width="70px"><col width="500px"><col width="100px">
<tr>
   <th>번호</th><th>댓글</th><th>작성자</th>
</tr>

<%
if(list == null || list.size() == 0){ // 쿼리문을 조회한 값이 담겨있는 리스트가 없거나 리스트가 비어있을 때
%>
   <tr>
      <td colspan="3">작성된 댓글이 없습니다</td>
   </tr>
<%
}else{ // 쿼리문을 조회한 값이 담겨있는 리스트가 존재할 때
   
   for(int i = 0;i < list.size(); i++){
	   BbsReplyDto bbs = list.get(i); // ArrayList안의 각각의 인덱스번호에 해당되는 데이터들을 차례대로 가져온다.
%>
      <tr>
         <th><%=(i + 1) %></th> <!-- 게시물의 번호, 번호는 1번부터 시작 -->
         <td>
            <%
            if(bbs.getDel() == 0){
               %>
               
               <%=bbs.getReplycontent() %> 
               
               <%
            }else{   
               %>
               <font color="#ff0000">***이 글은 작성자에 의해서 삭제되었습니다***</font>
               <%
            }
            %>
            
         </td>
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

</body>
</html>