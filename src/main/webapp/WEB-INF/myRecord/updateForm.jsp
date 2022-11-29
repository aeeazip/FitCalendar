<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Record"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>recordForm</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/recordForm.css' />"
	type="text/css">
<style>
#recordB {
	background: linear-gradient(91.36deg, #556B2F -24.31%, #a8eb8b 130.3%);
	box-shadow: 0px -10px 40px rgba(#556B2F, 0.3);
	border-radius: 12px;
	border: none;
	color: white;
	text-align: center;
	display: inline-block;
	font-size: 18px;
	font-weight: 600;
	height: 40px;
	padding: 12px 0;
	cursor: pointer;
}
</style>
</head>
<%
Record record = (Record) request.getAttribute("record");
%>
<script type="text/javascript">
	function signUpCheck() {
		if (form.title.value == "") {
			alert("제목을 입력하십시오.");
			form.title.focus();
			return false;
		}
		if (form.creationDate.value == "") {
			alert("생성 날짜를 입력하십시오.");
			form.creationDate.focus();
			return false;
		}
		if (form.totalTime.value == "") {
			alert("총 운동 시간을 입력하십시오.");
			form.totalTime.focus();
			return false;
		}
		if (form.category.value == "" || form.category.value == "종목을 선택하세요.") {
			alert("종목을 입력하십시오.");
			form.category.focus();
			return false;
		}
		if (form.routine.value == "") {
			alert("운동 루틴을 입력하십시오.");
			form.routine.focus();
			return false;
		}
		if (form.diet.value == "") {
			alert("식단을 입력하십시오.");
			form.diet.focus();
			return false;
		}
		if (form.shareOption.value == ""
				|| form.shareOption.value == "기록 공유를 하시겠습니까?") {
			alert("공유 옵션을 입력하십시오.");
			form.shareOption.focus();
			return false;
		}
		console.log("form submit");
		form.submit();
	}
</script>

<body>

	<%@ include file="../frameHeader.jsp"%>
	<input type="hidden" name="test" value="${record.recordId}" />
	<!-- container -->
	<!-- recordForm 부분 -->
	<div class="container">
		<form name="form" method="POST"
			action="<c:url value='/myRecord/update'/>">
			<div class="recordForm">
				<!-- 로그인 구현 후 session에서 exerciserId 갖고 오도록 구현 -->
				<h1 style="font-size: 21px;">${NickName}님의운동일지</h1>
			</div>
			<div class="name">
				<input type="text" name="title" placeholder="제목을 입력해 주세요."
					value="${record.title}">
			</div>
			<div class="name">
				<%
				String d = record.getCreationDate();
				String str = d.substring(0, 10);
				%>
				<input type="date" name="creationDate" value="<%=str%>">
			</div>
			<div class="name">
				<input type="text" name="totalTime"
					placeholder="총 운동시간을 입력해 주세요. (예: 3)" value="${record.totalTime}">
			</div>
			<div class="line">
				<hr>
			</div>
			<div class="area">
				<select id="category" name="category">
					<option selected>종목을 선택하세요.</option>
					<option value="1">헬스</option>
					<option value="2">필라테스</option>
					<option value="3">요가</option>
					<option value="4">러닝</option>
					<option value="5">기타</option>
				</select>
			</div>
			<div class="name">
				<textarea rows="5" cols="110%" name="routine"
					aria-label="With textarea" placeholder="운동 루틴을 입력하세요.">${record.routine}</textarea>
			</div>
			<div class="name">
				<textarea rows="5" cols="110%" name="diet"
					aria-label="With textarea" placeholder="식단을 입력하세요.">${record.diet}</textarea>
			</div>
			<div class="name">
				<input type="file" name="photo" value="${record.photo}">
			</div>
			<div class="name">
				<select name="shareOption">
					<option selected>기록 공유를 하시겠습니까?</option>
					<option value="1">예</option>
					<option value="0">아니오</option>
				</select>
			</div>
			<div class="button">
				<button type="button" id="recordB" onclick="signUpCheck()">등록하기</button>
			</div>
		</form>
	</div>

	<!-- footer -->
	<%@ include file="../frameFooter.jsp"%>
</body>
</html>