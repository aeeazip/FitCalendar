<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>matchingMenu!!!</title>
<link rel="stylesheet" href="<c:url value='../css/frame.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/myPageMenu.css' />"
	type="text/css">
</head>
<%@ include file="../frameHeader.jsp"%>
<div id="subTitle">
	<p class="subTitle">${nickname}님의 Matching 옵션  정보입니다.</p>
	<p class="category2" align="center" style="margin-bottom: 20px;">
		<c:if test="${useMatchSvc eq 'T'}">
			<input type="radio" checked>&nbsp;&nbsp;매칭 가능 상태
				</c:if>
		<c:if test="${useMatchSvc eq 'F'}">
			<input type="radio" checked>&nbsp;&nbsp;매칭 불가능 상태
				</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 원하는 fitmate 수 : ${maxMate}명
	</p>
</div>

<div id="main" style="padding-bottom: 30px;">
	<div class="flex-container2">
		<!-- 메인 -->
		<div>

			<div class="flex-container-icon">
				<div class="flex-container-icon-sub1">
					<a href="./getRecommendList">
						<div class="category2">요청받은 Fitmate</div>
					</a>
				</div>
			</div>

			<div class="flex-container-icon">
				<div class="flex-container-icon-sub1">
					<a href="./wantRecommend">
						<div class="category2">Fitmate 추천받기</div>
					</a>
				</div>
			</div>

			<div class="flex-container-icon">
				<div class="flex-container-icon-sub1">
					<a href="./situation/list">
						<div class="category2">요청 상태 관리</div>
					</a>
				</div>
			</div>

			<div class="flex-container-icon">
				<div class="flex-container-icon-sub1">
					<a href="./option">
						<div class="category2">Fitmate 수 재설정하기</div>
					</a>
				</div>
			</div>

			<div class="flex-container-icon">
				<div class="flex-container-icon-sub1">
					<a href="./option/endOption">
						<div class="category2">매칭 서비스 종료하기</div>
					</a>
				</div>
			</div>

			<div class="flex-container-icon2">
				<div class="flex-container-icon-sub1"></div>
				<div id="out">
					<button type="button" class="backBtn" onclick="history.back();">이전으로</button>
				</div>
			</div>


		</div>
	</div>
</div>


<%@ include file="../frameFooter.jsp"%>