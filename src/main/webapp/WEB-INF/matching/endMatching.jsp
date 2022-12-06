<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>endMatching!!!</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp"%>
<div id="main">

	<form name="endMateForm" action="<c:url value='/matching/option/setOption' />" method="POST">
		<div id="subTitle" style="margin-left:65px">
			<p class="subTitle2" style="margin-bottom:10px">${nickname}님 매칭 서비스를 종료하시겠습니까?</p>
			<p class="subTitle2">매칭 서비스는 다시 이용하실 수 있습니다.</p>
		</div>

		<button type="submit" class="start_btn">매칭 서비스 종료하기</button>

	</form>
	
	<form name="startMateForm"
				action="<c:url value='/matching/matchingMenu' />" method="GET">
				<button type="submit" class="start_btn" style="margin-top:15px;">menu 화면으로 돌아가기</button>
	</form>
</div>

<%@ include file="../frameFooter.jsp"%>