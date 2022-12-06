<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>setMate!!</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
<div id="main">
	<form name="setMaxMateForm" action="<c:url value='/matching/option/setMate' />" method="POST">
		<div id="subTitle" style="margin-left:50px">
           <p class="subTitle2">소통하고 싶은 최대 Mate 수를 재입력하세요!</p>
        </div>
		
		<input type="text" name="maxMate" class="input" 
		 placeholder="소통하고 싶은 최대 Mate 수"
          onfocus="this.placeholder = ''" 
          onblur="this.placeholder = '소통하고 싶은 최대 Mate 수'">
		
		<button type="submit" value="제출" class="start_btn" >옵션 바꾸기</button>
	</form>
	
	<form name="startMateForm"
				action="<c:url value='/matching/matchingMenu' />" method="GET">
				<button type="submit" class="start_btn" style="margin-top:15px;">menu 화면으로 돌아가기</button>
	</form>
</div>
<%@ include file="../frameFooter.jsp" %>
