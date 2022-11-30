<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>registerForm</title>
    <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/registerForm.css' />" type="text/css">
        <script type="text/javascript">
    	function userCreate() {
    		if(form.id.value == "") {
    			alert("사용자 아이디를 입력하십시오.");
    			form.id.focus();
    			return false;
    		} if(form.password.value == "") {
    			alert("사용자 패스워드를 입력하십시오.");
    			form.password.focus();
    			return false;
    		} if(form.nickname.value == "") {
    			alert("사용자 닉네임을 입력하십시오.");
    			form.nickname.focus();
    			return false;
    		} if(form.explanation.value == "") {
    			alert("사용자 한줄소개를 입력하십시오.");
    			form.explanation.focus();
    			return false;
    		} if(form.personality.value == "") {
    			alert("사용자 성격을 입력하십시오.");
    			form.personality.focus();
    			return false;
    		} if(form.height.value == "") {
    			alert("사용자 키를 입력하십시오.");
    			form.height.focus();
    			return false;
    		} if(form.weight.value == "") {
    			alert("사용자 몸무게를 입력하십시오.");
    			form.weight.focus();
    			return false;
    		} if(form.skeletalmm.value == "") {
    			alert("사용자 골격근량을 입력하십시오.");
    			form.skeletalmm.focus();
    			return false;
    		} if(form.percentbodyfat.value == "") {
    			alert("사용자 체지방률을 입력하십시오.");
    			form.percentbodyfat.focus();
    			return false;
    		} if(form.visceralfat.value == "") {
    			alert("사용자 내장지방레벨을 입력하십시오.");
    			form.visceralfat.focus();
    			return false;
    		} if(form.measuredate.value == "") {
    			alert("사용자 측정날짜를 입력하십시오.");
    			form.measuredate.focus();
    			return false;
    		}
    		console.log("form submit");
    		form.submit();
    	}
    </script>

</head>


<%@ include file="../frameHeader.jsp" %>

   	<div id="main">
       <form name="form" method="POST" action="<c:url value='/exerciser/register' />">
           <div class="flex-container2">
               <div id="subTitle">
                   <p class="subTitle">회원가입</p>
               </div>
               <div id="loginBox">
                   <div class="box">
                       <input type="text" class="inputInfo" id="id" maxlength="30" name="id"
                       placeholder="아이디"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '아이디'">
                       <p class="alert validId1"></p>
                   </div>
                   <div class="box">
                       <input type="password" class="inputInfo" id="pswd1" maxlength="30" name="password"
                       placeholder="비밀번호"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '비밀번호'">
                       <p class="alert validpwd2"></p>
                   </div>
                   <div class="box">
                       <input type="text" class="inputInfo" maxlength="30" name="nickname"
                       placeholder="닉네임"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '닉네임'">
                   </div>
                   <div class="box">
                       <input type="text" class="inputInfo" maxlength="30" name="explanation"
                       placeholder="한줄소개"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '한줄소개'">
                   </div>
                   <div class="box">
                       <input type="text" class="inputInfo" maxlength="30" name="personality"
                       placeholder="성격"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '성격'">
                   </div>
                   <div class="box">
                   	<div class="inputS">주로 하는 운동 종목</div>
                   	<select name="speciality" class="Stype">
                   		<option selected value="헬스">헬스</option>
                   		<option value="요가/필라테스">요가/필라테스</option>
                   		<option value="러닝">러닝</option>
                   		<option value="기타">기타</option>
                   	</select>
                   </div>
                   <div class="box">
                   	<div class="inputGender">성별</div>
                   	<select name="gender" class="Gtype">
                   		<option selected value="F">여</option>
                   		<option value="M">남</option>
                   	</select>
                   </div>
                   <div class="inbodyBox">*InBody 정보</div>
                   <div class="box">
                       <input type="text" class="regisInbody" maxlength="30" name="height"
                       placeholder="키"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '키'">
                   </div>
                   <div class="box">
                       <input type="text" class="regisInbody" maxlength="30" name="weight"
                       placeholder="몸무게"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '몸무게'">
                   </div>
                   <div class="box">
                       <input type="text" class="regisInbody" maxlength="30" name="skeletalmm"
                       placeholder="골격근량"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '골격근량'">
                   </div>
                   <div class="box">
                       <input type="text" class="regisInbody" maxlength="30" name="percentbodyfat"
                       placeholder="체지방률"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '체지방률'">
                   </div>
                   
                   <div class="box">
                       <input type="text" class="regisInbody" maxlength="30" name="visceralfat"
                       placeholder="내장지방레벨"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '내장지방레벨'">
                   </div>
                   <div class="box">
                       <input type="date" class="regisInbody" maxlength="30" name="measuredate"
                       placeholder="측정날짜"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '측정날짜'">
                   </div>
               </div>
               <div><button type="button" id="register_btn" onclick="userCreate();">회원가입</button></div>
           </div>
       </form>
   </div>
            

<%@ include file="../frameFooter.jsp" %>