<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>messageForm</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/recordForm.css' />" type="text/css">
	 <link rel="stylesheet" href="<c:url value='/css/registerForm.css' />" type="text/css">
    
	<script type="text/javascript">
	function signUpCheck() {
		if (form.content.value == "") {
			alert("메시지 내용을 입력하십시오.");
			form.content.focus();
			return false;
		}
		console.log("form submit");
		form.submit();
	}
	</script>
</head>
<%@ include file="../../frameHeader.jsp"%>

<div id="main">
		<form name="form" method="POST" action="<c:url value='/matching/fitmate/message/write' />">
           <div class="flex-container2 ">
               <div id="subTitle">
                   <p class="subTitle" style="font-size:18px; margin-bottom:20px;">${nickname}님에게 보내는 메시지</p>
               </div>
               
               <div id="loginBox">
                   <div class="box">
                       <textarea rows="10"  class="Qtype4" name="content" id="content"
                       placeholder="메시지 내용을 입력하세요."
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '메시지 내용을 입력하세요.'"></textarea>
                   </div>
                   <div><button type="button" id="record_btn" onclick="signUpCheck();">전송하기</button></div>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="../../frameFooter.jsp"%>