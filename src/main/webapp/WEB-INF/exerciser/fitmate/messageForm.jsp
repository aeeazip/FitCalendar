<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MessageForm</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/messageForm.css' />"
	type="text/css">
</head>
<script type="text/javascript">
	function signUpCheck() {
		if (form.content.value == "") {
			alert("메시지 내용을 입력하십시오.");
			form.content.focus();
			return false;
		}
		console.log("form submit");
		form.submit();
	}
</script>

<body>
	<%@ include file="../../frameHeader.jsp"%>
	<br><br><br>
	
	<!-- container -->
	<!-- recordForm 부분 -->
	<div class="container">
		<form name="form" method="POST"
			action="<c:url value='/matching/fitmate/message/write' ></c:url>">
			<div class="recordForm">
				<!-- 로그인 구현 후 session에서 exerciserId 갖고 오도록 구현 -->
				<h1 style="font-size: 21px;">${nickname}님에게 보내는 메시지</h1>
			</div>
			<br><br><br>
			<div class="name">
				<textarea rows="10" cols="110%" name="content"
					aria-label="With textarea" placeholder="메시지 내용을 입력하세요"></textarea>
			</div>
			<div class="button">
				<button type="button" id="sendMessage_btn" onclick="signUpCheck()">전송하기</button>
			</div>
		</form>
	</div>

	<!-- footer -->
	<%@ include file="../../frameFooter.jsp"%>
</body>
</html>