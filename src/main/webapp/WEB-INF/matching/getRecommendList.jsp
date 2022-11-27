<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>Matching request processing!!!</title>
   <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<script type="text/javascript">
    	function accept() {
    		location.href="<c:url value='/matching/fitmateList' />";
    	}
    	function refuse() {
    		location.href="<c:url value='/matching/getRecommendList' />";
    	}
    </script>
</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align = "center">
	<h2>나에게 요청을 보낸 예비 Fitmate입니다!<br>수락/거절을 하세요!</h2>
	
	<c:if test="${empty getRecommList}">
	현재 getRecommList가 없습니다. 
	</c:if>
	<c:if test="${not empty getRecommList}">
	<table>
		<c:forEach var = "list" items="${getRecommList}" varStatus="status">
		<tr>
			<td>
				No. <c:out value="${status.count}" />
				<p>닉네임: <c:out value="${list.nickname}" />
				<p>한줄소개: <c:out value="${list.explanation}" />
				<p>운동종목 : <c:out value="${list.speciality}" />
				<p>성격 : <c:out value="${list.personality}" />
				<p>성별 : <c:out value="${list.gender}" />
			</td>
			<td>
				<button type="button" onclick="accept()">수락하기</button>
				<br>
				<button type="button" onclick="refuse()">거절하기</button>
			</td>
		</tr>
		</c:forEach>
		
	</table>
   	</c:if>
</div>   
</body>
<%@ include file="../frameFooter.jsp" %>
