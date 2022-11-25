<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>loginForm</title>
    <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/loginForm.css' />" type="text/css">
     <script type="text/javascript">
    	function login() {
    		if(form.id.value == "") {
    			alert("사용자 아이디를 입력하십시오.");
    			form.id.focus();
    			return false;
    		} if(form.pwd.value == "") {
    			alert("사용자 패스워드를 입력하십시오.");
    			form.pwd.focus();
    			return false;
    		} 
    		console.log("form submit");
    		form.submit();
    	}
    </script>
</head>


<%@ include file="../frameHeader.jsp" %>


    <div id="main">
         <form name="form" method="POST" action="<c:url value='/exerciser/login' />">
            <div class="flex-container2">
                <div id="subTitle">
                    <p class="subTitle">로그인</p>
                </div>
                <div id="loginBox">
                    <div class="box">
                        <input type="text" class="inputId" id="id" maxlength="30" name="id"
                        placeholder="아이디"
                        onfocus="this.placeholder = ''" 
                        onblur="this.placeholder = '아이디'">
                        <p class="alert validId1"></p>
                    </div>
                    <div class="box">
                        <input type="password" class="inputPW" id="pswd1" maxlength="30" name="pwd"
                        placeholder="비밀번호"
                        onfocus="this.placeholder = ''" 
                        onblur="this.placeholder = '비밀번호'">
                        <p class="alert validpwd2"></p>
                    </div>
                </div>
                <div><button type="button" id="login_btn" onclick="login();">로그인</button></div>
            </div>
        </form>
    </div>
    <div class="findinfo">
        <a href="<c:url value='/exerciser/register' />" class="signUPTxt">회원가입</a>
    </div>
    
    

<%@ include file="../frameFooter.jsp" %>