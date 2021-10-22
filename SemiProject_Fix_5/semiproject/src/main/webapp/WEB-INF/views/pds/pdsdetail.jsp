<%@page import="our.own.trip.dto.PdsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
PdsDto pds =(PdsDto)request.getAttribute("pds");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div align="center">
	<div style="width: 1000px">

	<table class="table">
	<col width="150"><col width="500">
	
	<tr>
		<th class="table-dark">아이디</th>
		<td><%=pds.getId() %></td>
	</tr>
	
	<tr>
		<th class="table-dark">제목</th>
		<td><%=pds.getTitle() %></td>
	</tr>
	
	<tr>
		<th class="table-dark">다운로드</th>
		<td>
			<%=pds.getFilename() %>
			<input type="button" value="다운로드"
				onclick="filedownload('<%=pds.getNewfilename() %>', '<%=pds.getFilename() %>', <%=pds.getSeq() %>)">
		</td>
	</tr>
	<tr>
		<th class="table-dark">조회수</th>
		<td><%=pds.getReadcount() %></td>
	</tr>
	<tr>
		<th class="table-dark">다운로드수</th>
		<td><%=pds.getDowncount() %></td>
	</tr>
	<tr>
		<th class="table-dark">등록일</th>
		<td><%=pds.getRegdate() %></td>
	</tr>	
	<tr>
		<th class="table-dark">내용</th>
		<td>
			<textarea class="form-control" rows="10"><%=pds.getContent() %></textarea>
		</td>
	</tr>
	</table>

</div>

<button type="button" class="btn btn-info" onclick="location.href='pdslist.do'">자료실목록</button>

</div>
<!-- 
수정하기
삭제하기
 -->

<script type="text/javascript">
function filedownload(newfilename, filename, seq) {
	location.href = "fileDownload.do?newfilename=" + newfilename + "&filename=" + filename + "&seq=" + seq;	
}
</script>

</body>
</html>







