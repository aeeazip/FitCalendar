<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Message" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AllRecord</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<style>
#messageList {
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
<body>
	<%@ include file="../../frameHeader.jsp" %>

	<%
		List<Message> sendList = (List<Message>)request.getAttribute("sendList");
		List<Message> receiveList = (List<Message>)request.getAttribute("receiveList");	
	%>
	<p>내가 Fitmate에게 보낸 메시지</p>
	<table id="messageList">
		<tr>
			<td align="center" bgcolor="E6ECDE" height="50">메시지번호</td>
			<td align="center" bgcolor="E6ECDE">메시지 내용</td>
			<td align="center" bgcolor="E6ECDE">작성일</td>
		</tr>
		<c:forEach var="sendList" items="${sendList}">
			<tr>
				<td align="center" bgcolor="ffffff" height="35">
					${sendList.msgId}</td>
				<td bgcolor="ffffff" style="padding-left: 10">
					${sendList.content}
				</td>
				<td bgcolor="ffffff" style="padding-left: 10" align="center">${sendList.sendDate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br><br>
	
	<p>Fitmate가 나에게 보낸 메시지</p>
	<table id="messageList">
		<tr>
			<td align="center" bgcolor="E6ECDE" height="50">메시지번호</td>
			<td align="center" bgcolor="E6ECDE">메시지 내용</td>
			<td align="center" bgcolor="E6ECDE">작성일</td>
		</tr>
		<c:forEach var="receiveList" items="${receiveList}">
			<tr>
				<td align="center" bgcolor="ffffff" height="35">
					${receiveList.msgId}</td>
				<td bgcolor="ffffff" style="padding-left: 10">
					${receiveList.content}
				</td>
				<td bgcolor="ffffff" style="padding-left: 10" align="center">${receiveList.sendDate}</td>
			</tr>
		</c:forEach>
	</table>

	<!-- 메시지 작성 -->
	<br><br>
	<div style="text-align: center;">
		<a href="<c:url value='/matching/fitmate/message/write'><c:param name='senderId' value='${sendList[0].senderId}'/><c:param name='receiverId' value='${receiveList[0].senderId}'/></c:url>">메시지 작성</a>
		
	</div>
	<%@ include file="../../frameFooter.jsp"%>
</body>
</html>