<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--    
<%
int seq = Integer.parseInt(request.getParameter("seq"));
%>
--%> 

<%
String delete = (String)request.getAttribute("delete");
int sort = (Integer)request.getAttribute("sort");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
if(sort == 1){
%>
  <%
  if(delete.equals("YES")){
  %>
    <script type="text/javascript">
    alert("글 수정 성공!");
    location.href = 'share.do';
    </script>
  <%	
  }else if(delete.equals("NO")){
  %>
    <script type="text/javascript">
    alert("글 수정 실패. 다시 수정해 주세요.");
    location.href = 'share.do';
    </script>
  <%
  }
  %>
<%	
}else if(sort == 2){
%>
  <%
  if(delete.equals("YES")){
  %>
    <script type="text/javascript">
    alert("글 수정 성공!");
    location.href = 'review.do';
    </script>
  <%	
  }else if(delete.equals("NO")){
  %>
    <script type="text/javascript">
    alert("글 수정 실패. 다시 수정해 주세요.");
    location.href = 'review.do';
    </script>
  <%
  }
  %>
<% 
}
%>
</body>
</html>







