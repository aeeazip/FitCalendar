<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>deleteForm</title>
   <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">

</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align = "center">

   <form name="deleteAccountForm" action="<c:url value='/mypage/delete' />" method="POST">
      <h2>회원 탈퇴</h2>
		<br><br>
		<c:if test="${deleteFailed}">
	  	  <br><font color="red"><c:out value="${exception}" /></font><br>
	    </c:if>
      <h3>비밀번호를 입력하세요</h3><br>
      <input type="password" name ="exerciserPwd"><br><br>
      <button type="submit">회원 탈퇴</button>
   </form>
</div>   
</body>
<%@ include file="../frameFooter.jsp" %>
