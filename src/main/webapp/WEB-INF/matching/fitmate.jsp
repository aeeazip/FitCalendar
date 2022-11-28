<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%!
	int count = 1;
%>
<meta charset="utf-8">
<title>Fitmate</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align ="center">
<h3>FitMate 목록입니다.</h3>

<c:if test="${empty fitmateList}">
	현재 요청하신 FitMate가 존재하지 않습니다.
</c:if>
<c:if test="${not empty fitmateList}">
<h2>FitMate 목록</h2>
<table>
	<c:forEach var="list" items="${fitmateList}" varStatus="status">
	<tr>
		<td>
			No. <%=count %>
			<p>닉네임: <c:out value="${list.nickname}" />
			<p>한줄소개: <c:out value="${list.explanation}" />
			<p>운동종목 : <c:out value="${list.speciality}" />
			<p>성격 : <c:out value="${list.personality}" />
			<p>성별 : <c:out value="${list.gender}" />
		</td>
		<td>
			<form name="messageForm"action="<c:url value='/matching/fitmate'/>" method="POST">
				<input type="hidden" name = "fitmateId" value="${list.id}"/>
				<button type="submit"  style="padding:3px; background-color: #A2C2B3; border-radius: 5px; border: none;">쪽지보내기</button>
			</form>
		</td>
	</tr>
	<%count++; %>
	</c:forEach>
	<%count = 1; %>
</tbody>
</c:if>
</table>
</div>

<%@ include file="../frameFooter.jsp" %>
</html>