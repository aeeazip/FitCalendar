<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>WantRecommend</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"type="text/css">
<link rel="stylesheet" href="<c:url value='/css/wantRecommend.css' />"type="text/css">
</head>
<%@ include file="../frameHeader.jsp"%>
<body>

	<div align="center">
		<form name="startRecommendForm"
			action="<c:url value='/matching/wantRecommend/recommendRequest' />"
			method="POST">
			<h3>
				FitMate 추천을 받고 싶다면 <br> 버튼을 누르세요!
			</h3>
			<br>
			<button type="submit" style="padding:8px; background-color: #A2C2B3; border-radius: 5px; border: none;">FitMate Recommend Start!</button>
		</form>
	</div>
</body>

<%@ include file="../frameFooter.jsp"%>
</html>