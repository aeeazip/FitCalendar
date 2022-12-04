<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>endMatching!!!</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />"
	type="text/css">

</head>
<%@ include file="../frameHeader.jsp"%>
<div id="main">

	<form name="endMateForm"
		action="<c:url value='/matching/option/setOption' />" method="POST">
		<div id="subTitle">
			<p class="subTitle">${nickname}님매칭 서비스를 종료하시겠습니까?</p>
		</div>

		<button type="submit" class="start_btn">매칭 서비스 종료하기</button>

		<div class="flex-container-icon2">
			<div class="flex-container-icon-sub1"></div>
			<div id="out">
				<button type="button" class="backBtn" onclick="history.back();">이전으로</button>
			</div>
		</div>
	</form>
</div>

<%@ include file="../frameFooter.jsp"%>