<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Message" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>AllRecord</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">
	<script>
		function recordRemove() {
			return confirm("정말 삭제하시겠습니까?");
		}
	</script>
	<style>
	 	.messageList { 
	 		border-collapse: collapse; 
	 	} 
 	</style>
</head>
	<%@ include file="../../frameHeader.jsp" %>

	<%
		List<Message> sendList = (List<Message>)request.getAttribute("sendList");
		List<Message> receiveList = (List<Message>)request.getAttribute("receiveList");	
		
		int i=1;
		int j=1;
	%>
	<div id="main">
	<div class="flex-container2">
		<div id="subTitle" >
		
			<p class="subTitle" align="left" style="font-size:18px; margin-bottom:10px;">내가 Fitmate에게 보낸 메시지</p>
				
			<div style="text-align: center">
					<form>
						<table class="messageList" style="table-layout: auto; table-layout: fixed;">
							<tr>
								<td align="center" bgcolor="E6ECDE" height="40" class="a" style="border-top: 1px solid black;">메시지번호</td>
								<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">메시지 내용</td>
								<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">작성일</td>
							</tr>
							<c:forEach var="sendList" items="${sendList}">
							<tr>
								<td align="center" bgcolor="ffffff" height="35"  class="a">
									<%=i++%></td>
								<td bgcolor="ffffff" class="b">
									${sendList.content}
								</td>
								<td bgcolor="ffffff" class="a">${sendList.sendDate}</td>
							</tr>
						</c:forEach>
						</table>
					</form>
				</div>
			
			
			<p class="subTitle" align="left" style="font-size:18px; margin-bottom:10px; margin-top:50px;">Fitmate가 나에게 보낸 메시지</p>
			<div style="text-align: center">
					<form>
						<table class="messageList" style="table-layout: auto; table-layout: fixed;">
							<tr>
								<td align="center" bgcolor="E6ECDE" height="40" class="a" style="border-top: 1px solid black;">메시지번호</td>
								<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">메시지 내용</td>
								<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">작성일</td>
							</tr>
						<c:forEach var="receiveList" items="${receiveList}">
							<tr>
								<td align="center" bgcolor="ffffff" height="35" class="a">
									<%=j++%></td>
								<td bgcolor="ffffff" class="b">
									${receiveList.content}
								</td>
								<td bgcolor="ffffff" class="a">${receiveList.sendDate}</td>
							</tr>
						</c:forEach>
						</table>
					</form>
				</div>
		
			<!-- 메시지 작성 -->
			<div style="text-align: center;">
				<a href="<c:url value='/matching/fitmate/message/write'><c:param name='senderId' value='${sendList[0].senderId}'/><c:param name='receiverId' value='${receiveList[0].senderId}'/></c:url>" class="record_btn">메시지 보내기</a>
			</div>
		</div>
	</div>
</div>
	<%@ include file="../../frameFooter.jsp"%>