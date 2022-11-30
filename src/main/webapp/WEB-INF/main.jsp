<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<%!int count = 1;%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>FitCalendar</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/css/main.css' />"
	type="text/css">
</head>

<style>
.left-box {
	position: relative;
	top: 500;
	left: 200px;
}

.right-box {
	position: relative;
	top: 500;
	right: 200px;
}
</style>


<%@ include file="frameHeader.jsp"%>
<c:if test="${!empty exerciser}">
	<div id="subTitle" align="center" class="left-box">
		<p class="subTitle">안녕하세요 ${nickname}님!</p>
		<br> <br> FitCalendar를 방문해주셔서 감사합니다! <br> <br> <br>
		현재 보유 포인트 : ${point } <br> <br> <br> 한줄 소개 : ${ explanation}
		<br> <br> <br> 성별 :
		<c:if test="${gender eq 'M' }">남자</c:if>
		<c:if test="${gender eq 'F' }">여자</c:if>

		<br> <Br> <br> <br> <br> <br>
	</div>

	<!-- 포인트 상위 랭킹 -->

	<div class="right-box">
		<table align="center">
			<c:forEach var="ranking" items="${rankingList}">
				<tr>
					<td><h3><%=count++ %>등
						</h3></td>
					<td><p>
							닉네임:
							<c:out value="${ranking.nickname}" />
							<br>
							<br>
							<p>보유 포인트:${ranking.point}<br>
							<br></td>
			</tr>
		</c:forEach>
		<%
			count = 1;
			%>
	</table>
	</div>

</c:if>
<c:if test="${empty exerciser}">
	<div id="subTitle" align="center">
		FitCalendar를 방문해주셔서 감사합니다! <br> <br> <br> 로그인을 해주세요!
	</div>
</c:if>

<%@ include file="frameFooter.jsp"%>