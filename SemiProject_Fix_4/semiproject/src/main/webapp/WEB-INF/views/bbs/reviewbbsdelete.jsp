<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String delete = (String)request.getAttribute("delete");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <%
  if(delete.equals("YES")){
  %>
    <script type="text/javascript">
    alert("글 삭제 성공!");
    location.href = 'review.do';
    </script>
  <%	
  }else if(delete.equals("NO")){
  %>
    <script type="text/javascript">
    alert("글 삭제 실패. 다시 삭제해 주세요.");
    location.href = 'review.do';
    </script>
  <%
  }
  %>

<%--   <%
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
  %> --%>

</body>
</html>







