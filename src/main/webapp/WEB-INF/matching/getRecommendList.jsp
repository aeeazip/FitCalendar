<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>Matching request processing!!!</title>
   <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">

</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align = "center">
	<h2>나에게 요청을 보낸 예비 Fitmate입니다!<br>수락/거절을 하세요!</h2>
	
	<c:if test="${empty getRecommList}">
	현재 getRecommList가 없습니다. 
	</c:if>
	<c:if test="${not empty getRecommList}">
		<c:forEach var = "list" items="${getRecommList}" varStatus="status">
			No. <c:out value="${status.count}" />
			<p>닉네임: <c:out value="${list.nickname}" />
			<p>한줄소개: <c:out value="${list.explanation}" />
			<p>운동종목 : <c:out value="${list.speciality}" />
			<p>성격 : <c:out value="${list.personality}" />
			<p>성별 : <c:out value="${list.gender}" />
	</c:forEach>
   	</c:if>
</div>   
</body>
<%@ include file="../frameFooter.jsp" %>
