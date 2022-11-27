<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>matchingMenu!!!</title>
	<link rel="stylesheet" href="<c:url value='../css/frame.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align = "center">

	<h3>${nickname}님의 option정보입니다.</h3>
	<br>
	<c:if test="${useMatchSvc eq 'T'}">
		<input type="radio" checked >매칭 가능 상태
	</c:if>
	<c:if test="${useMatchSvc eq 'F'}">
		<input type="radio" checked >매칭 불가능 상태
	</c:if>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	원하는 fitmate 수 : ${maxMate}명
 	<br><br>
 
	<a href="./getRecommendList.jsp">요청받은 fitmate</a><br><br>
	<a href="./ ????????????????????잉우꺼!!!!!!!!!!!!!!!!!!">요청받고 싶은 fitmate</a><br><br>
	<a href="./situation.jsp">요청 상태 관리</a><br><br>
	<a href="./setOptions.jsp">옵션 바꾸기</a><br>
</div>   
</body>

<%@ include file="../frameFooter.jsp" %>
</html>