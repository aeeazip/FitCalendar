<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RecommendList</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value='/css/wantRecommendList.css' />" type="text/css">
<%
	String fitmateId = (String)request.getAttribute("recommId");
	session.setAttribute("fitMateId",fitmateId);
	System.out.println(fitmateId);
%>

</head>
<%@ include file="../frameHeader.jsp"%>
<body>
	<div align="center">
		<h3>추천 FitMate</h3>
		<table>
			<tr>
				<td>NickName</td>
				<td>${recomm.nickname}</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>${recomm.gender}</td>
			</tr>
			<tr>
				<td>운동 주종목</td>
				<td>${recomm.speciality}</td>
			</tr>
			<tr>
				<td>한줄 소개</td>
				<td>${recomm.explanation}</td>
			</tr>
			<tr>
				<td>성격</td>
				<td>${recomm.personality}</td>
			</tr>
		</table>
		<br>
		<br>
		<form name="startMateForm"
			action="<c:url value='/matching/wantRecommend/list/request' />"
			method="POST">
			<button type="submit"  style="padding:3px; background-color: #A2C2B3; border-radius: 5px; border: none;">Fitmate 요청</button>
		</form>
		<br>
		<form name="startMateForm"
			action="<c:url value='/matching/wantRecommend/list/reRequest' />"
			method="POST">
			<button type="submit" style="padding:3px; background-color: #A2C2B3; border-radius: 5px; border: none;">재추천</button>
		</form>

	</div>
</body>

<%@ include file="../frameFooter.jsp"%>
</html>