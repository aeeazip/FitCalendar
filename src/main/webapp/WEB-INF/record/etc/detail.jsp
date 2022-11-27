<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Record"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Record record = (Record) request.getAttribute("record");
String nickname = (String) request.getAttribute("nickname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ETC Category Record</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<script>
	function recordRemove() {
		return confirm("정말 삭제하시겠습니까?");
	}
</script>
<style>
table {
	width: 100%;
	border-top: 1px solid #444444;
	border-collapse: collapse;
}

td {
	border-bottom: 1px solid #444444;
	padding: 10px;
}
</style>
</head>
<body style="width: 100%;">
	<%@ include file="../../frameHeader.jsp"%>

	<table width="800">
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">글 번호</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">&nbsp;&nbsp;&nbsp;&nbsp;<%=record.getRecordId()%>
			</td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">제목</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">&nbsp;&nbsp;&nbsp;&nbsp;<%=record.getTitle()%>
			</td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">날짜</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">
				&nbsp;&nbsp;&nbsp;&nbsp;${record.creationDate}</td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">운동
				종류</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">&nbsp;&nbsp;&nbsp;&nbsp;기타</td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">총
				운동시간</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">&nbsp;&nbsp;&nbsp;&nbsp;${record.totalTime}</td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">운동
				루틴</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">&nbsp;&nbsp;&nbsp;&nbsp;${record.routine}</td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">운동
				식단</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">&nbsp;&nbsp;&nbsp;&nbsp;${record.diet}</td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="200">사진</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">${record.photo}</td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">공유
				허용</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10"><c:if
					test="${record.shareOption eq '1'}">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;예</p>
				</c:if> <c:if test="${record.shareOption eq '0'}">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;아니요</p>
				</c:if></td>
		</tr>
		<tr>
			<td width="300" align="center" bgcolor="E6ECDE" height="40">작성자</td>
			<td width="500" bgcolor="ffffff" style="padding-left: 10">&nbsp;&nbsp;&nbsp;&nbsp;${nickname}</td>
		</tr>
	</table>
	<br>

	<!-- 수정 및 삭제 -->
	<div style="text-align: center;">
		<a
			href="<c:url value='/myRecord/update'>
	     		   <c:param name='recordId' value='<%=String.valueOf(record.getRecordId())%>'/>
			 	 </c:url>">수정</a>
		&nbsp; <a
			href="<c:url value='/myRecord/delete'>
				   <c:param name='recordId' value='<%=String.valueOf(record.getRecordId())%>'/>
			 	 </c:url>"
			onclick="return recordRemove();">삭제</a> &nbsp; <a
			href="<c:url value='/myRecord/list' />">목록</a> <br> <br>
	</div>

	<%@ include file="../../frameFooter.jsp"%>
</body>
</html>