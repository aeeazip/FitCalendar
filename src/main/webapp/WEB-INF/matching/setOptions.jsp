<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>setMate!!</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align = "center">
	<form name="setMaxMateForm" action="<c:url value='/matching/setMate' />" method="POST">
		소통하고 싶은 최대 Mate 수를 재입력하세요! <br><br>
		<input type="text" name="maxMate">
		
		<input type="reset" value="재입력"> 
		<input type="submit" value="제출"> 		
	</form>
</div>
</body>
<%@ include file="../frameFooter.jsp" %>
</html>