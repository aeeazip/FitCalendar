<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="EUC-KR">
<title>recordForm</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css" />
</head>
<body>
	<%@ include file="../frameHeader.jsp"%>
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
				<td bgcolor="ffffff" style="padding-left: 10"><a
					href="<c:url value='/myRecord/list/detail'><c:param name='recordId' value='${record.recordId}'/></c:url>">${record.title}</a>
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
				<td bgcolor="ffffff" style="padding-left: 10" align="center">${nickname}</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="../frameFooter.jsp"%>
</body>
</html>