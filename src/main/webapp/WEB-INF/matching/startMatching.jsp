<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>startMatching!!!</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />"
	type="text/css">

</head>
<%@ include file="../frameHeader.jsp"%>
<div id="main">

	<form name="startMateForm"
		action="<c:url value='/matching/option/setMate' />" method="POST">
		<div id="subTitle">
			<p class="subTitle">${nickname}님FitMate 매칭을 시작해보세요!</p>
		</div>
		<input type="text" class="input" name="maxMate" id="num"
			placeholder="맺고싶은 fitmate 수를 입력하세요." onfocus="this.placeholder = ''"
			onblur="this.placeholder = '맺고싶은 fitmate 수를 입력하세요.'">

		<button type="submit" class="start_btn">매칭
			서비스 시작하기</button>
	</form>
</div>

<%@ include file="../frameFooter.jsp"%>