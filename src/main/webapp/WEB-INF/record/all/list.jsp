<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Record" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AllRecord</title>
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

	<%
		List<Record> recordList = (List<Record>) request.getAttribute("recordList");
		List<String> nickNameList = (List<String>)request.getAttribute("nickNameList");
		String category = (String)request.getAttribute("category");
		
		int i = 0;
	%>
	
	<table id="recordT">
		<tr>
			<td align="center" bgcolor="E6ECDE" height="50">글 번호</td>
			<td align="center" bgcolor="E6ECDE">제목</td>
			<td align="center" bgcolor="E6ECDE">분류</td>
			<td align="center" bgcolor="E6ECDE">작성자</td>
		</tr>
		<c:forEach var="record" items="${recordList}">
			<tr>
				<td align="center" bgcolor="ffffff" height="35">
					${record.recordId}</td>
				<td bgcolor="ffffff" style="padding-left: 10">
					<a href="<c:url value='/allRecord/list/detail'><c:param name='recordId' value='${record.recordId}'/></c:url>">${record.title}</a>
				</td>
				<td bgcolor="ffffff" style="padding-left: 10" align="center"><c:if
						test="${record.category eq '1'}">
						<p>헬스</p>
					</c:if> <c:if test="${record.category eq '2'}">
						<p>필라테스</p>
					</c:if> <c:if test="${record.category eq '3'}">
						<p>요가</p>
					</c:if> <c:if test="${record.category eq '4'}">
						<p>러닝</p>
					</c:if> <c:if test="${record.category eq '5'}">
						<p>기타</p>
					</c:if></td>
				<td bgcolor="ffffff" style="padding-left: 10" align="center"><%=nickNameList.get(i++) %></td>
			</tr>
		</c:forEach>
	</table>

	<%@ include file="../../frameFooter.jsp"%>
</body>
</html>