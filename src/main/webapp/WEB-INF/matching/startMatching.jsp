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

   <form name="startMateForm" action="<c:url value='/matching/setMate' />" method="POST">
      <h2>${nickname}님 FitMate 매칭을 시작해보세요!</h2>
		<br><br>
      <h3>맺고싶은 fitmate 수를 입력하세요</h3><br>
      <input type="text" name ="maxMate"><br><br>
      <br>버튼을 클릭해주세요!<br><br>
      <button type="submit">매칭 시작하기</button>
   </form>
</div>   
</body>
<%@ include file="../frameFooter.jsp" %>
