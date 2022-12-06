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
	<link rel="stylesheet"
		href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">
	<script>
		function recordRemove() {
			return confirm("정말 삭제하시겠습니까?");
		}
	
		function send() {
			var x = document.getElementById("recieve");
			var y = document.getElementById("send");
			if (y.style.display === "none") {
				x.style.display = "none";
				y.style.display = "block";
			} else {
				x.style.display = "none";
				y.style.display = "block";
			}
	
		}
	
		function recieve() {
			var x = document.getElementById("send");
			var y = document.getElementById("recieve");
			if (y.style.display === "none") {
				x.style.display = "none";
				y.style.display = "block";
			} else {
				x.style.display = "none";
				y.style.display = "block";
			}
	
		}
	</script>
	<style>
	.messageList {
		border-collapse: collapse;
	}
	</style>
</head>
<%@ include file="../../frameHeader.jsp"%>

<%
List<Message> sendList = (List<Message>) request.getAttribute("sendList");
List<Message> receiveList = (List<Message>) request.getAttribute("receiveList");

int i = 1;
int j = 1;
%>

<button type="button" class="send_btn" onClick="send()" style="margin-left:30px;">보낸 메세지함</button>
<button type="button" class="send_btn" onClick="recieve()">받은 메세지함</button>

<div id="main" style="margin-top:20px;">
	<div class="flex-container2">
		<div id="subTitle">
			<div id="send">
				<p class="subTitle" align="left"
					style="font-size: 18px; margin-bottom: 10px;">보낸 메세지함</p>

				<div style="text-align: center">
					<form>
						<table class="messageList"
							style="table-layout: auto; table-layout: fixed;">
							<tr>
								<td align="center" bgcolor="E6ECDE" height="40" class="a"
									style="border-top: 1px solid black;">메시지번호</td>
								<td align="center" bgcolor="E6ECDE" class="a"
									style="border-top: 1px solid black;">메시지 내용</td>
								<td align="center" bgcolor="E6ECDE" class="a"
									style="border-top: 1px solid black;">작성일</td>
							</tr>
							<c:forEach var="sendList" items="${sendList}">
								<tr>
									<td align="center" bgcolor="ffffff" height="35" class="a">
										<%=i++%></td>
									<td bgcolor="ffffff" class="b">${sendList.content}</td>
									<td bgcolor="ffffff" class="a">${sendList.sendDate}</td>
								</tr>
							</c:forEach>
						</table>
					</form>
				</div>
			</div>

			<div id="recieve" style="display:none;">
			<p class="subTitle" align="left"
				style="font-size: 18px; margin-bottom: 10px;">받은 메세지함</p>
			<div style="text-align: center">
				<form>
					<table class="messageList"
						style="table-layout: auto; table-layout: fixed;">
						<tr>
							<td align="center" bgcolor="E6ECDE" height="40" class="a"
								style="border-top: 1px solid black;">메시지번호</td>
							<td align="center" bgcolor="E6ECDE" class="a"
								style="border-top: 1px solid black;">메시지 내용</td>
							<td align="center" bgcolor="E6ECDE" class="a"
								style="border-top: 1px solid black;">작성일</td>
						</tr>
						<c:forEach var="receiveList" items="${receiveList}">
							<tr>
								<td align="center" bgcolor="ffffff" height="35" class="a">
									<%=j++%></td>
								<td bgcolor="ffffff" class="b">${receiveList.content}</td>
								<td bgcolor="ffffff" class="a">${receiveList.sendDate}</td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</div>
		</div>
		<!-- 메시지 작성 -->
		<div style="text-align: center;">
			<a
				href="<c:url value='/matching/fitmate/message/write'><c:param name='senderId' value='${sendList[0].senderId}'/><c:param name='receiverId' value='${receiveList[0].senderId}'/></c:url>"
				class="record_btn">메시지 보내기</a>
		</div>
	</div>
</div>
</div>
<%@ include file="../../frameFooter.jsp"%>