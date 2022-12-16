<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Matching Situation</title>
	<link rel="stylesheet" href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	
</head>
<%@ include file="../frameHeader.jsp"%>


<div id="main">
	<div class="flex-container2">
		<div id="subTitle" >
           <p class="subTitle" style="font-size:18px; margin-bottom:30px;">FitMate 요청 상태</p>
 	 	</div>


		<c:if test="${empty matchingStatus}">
		<p class="subTitle" style="font-size:18px; margin-bottom:30px;">현재 요청하신 FitMate가 존재하지 않습니다.</p>
		</c:if>
		<c:if test="${not empty matchingStatus}">
		<div style="text-align: center">
		<form>
			<table style="table-layout: auto; table-layout: fixed;">
					<c:forEach var="result" items="${matchingStatus}"
						varStatus="status">
						<tr>
							<td class="a" style="border-top: 1px solid black;"><c:out value="${result.receiverNickName}" /></td>
							<c:if test="${ 1 eq result.status }">
								<td class="a" style="border-top: 1px solid black;">요청 수락 O</td>
							</c:if>
							<c:if test="${ 2 eq result.status }">
								<td class="a" style="border-top: 1px solid black;">요청 대기</td>
							</c:if>
							<c:if test="${ 3 eq result.status }">
								<td class="a" style="border-top: 1px solid black;">요청 거절</td>
							</c:if>
						</tr>
					</c:forEach>
			</table>
			</form>
			</div>
			</c:if>
			
			
			<form name="startMateForm"
				action="<c:url value='/matching/matchingMenu' />" method="GET">
				<button type="submit" class="fitmatelist_btn" >menu 화면으로 돌아가기</button>
			</form>
			
			<form name="startMateForm"
				action="<c:url value='/matching/wantRecommend' />" method="GET">
				<button type="submit" class="fitmatelist_btn" >Fitmate 추천받기</button>
			</form>
	</div>
</div>
	<%@ include file="../frameFooter.jsp"%>
