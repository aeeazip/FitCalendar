<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>deleteForm</title>
   <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
   <link rel="stylesheet" href="<c:url value='/css/deleteForm.css' />" type="text/css">

</head>
<%@ include file="../frameHeader.jsp" %>

<div id="main">

   <form name="deleteAccountForm" action="<c:url value='/mypage/delete' />" method="POST">
      	<div id="subTitle">
           <p class="subTitle">회원 탈퇴</p>
        </div>
		<c:if test="${deleteFailed}">
	  	  <br><font color="red"><c:out value="${exception}" /></font><br>
	    </c:if>
	     <div class="box">
              <input type="password" class="inputPW" name="exerciserPwd"
              placeholder="비밀번호를 입력하세요"
              onfocus="this.placeholder = ''" 
              onblur="this.placeholder = '비밀번호를 입력하세요'">
          </div>
      <button type="submit" id="delete_btn">회원 탈퇴</button>
   </form>
</div>   

<%@ include file="../frameFooter.jsp" %>
