<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>startMatching!!!</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align = "center">
	<form name="startMateForm" action="setMaxMate.jsp" method="GET">
		<h2>FitMate 매칭을 시작하시려면 버튼을 클릭해주세요!</h2>
		<button onclick="locaton='setMaxMate.jsp'">매칭 시작하기</button>
	</form>
</div>	
</body>
</html>