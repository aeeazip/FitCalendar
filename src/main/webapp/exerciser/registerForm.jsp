<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>registerForm</title>
    <link rel="stylesheet" href="registerForm.css">
    <link rel="stylesheet" href="frame.css">
</head>


<%@ include file="frameHeader.jsp" %>

   	<div id="main">
       <form>
           <div class="flex-container2">
               <div id="subTitle">
                   <p class="subTitle">회원가입</p>
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
                       <input type="password" class="inputPW" id="pswd1" maxlength="30" name="password"
                       placeholder="비밀번호"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '비밀번호'">
                       <p class="alert validpwd2"></p>
                   </div>
                   <div class="box">
                       <input type="text" class="inputPW" maxlength="30" name="nickname"
                       placeholder="닉네임"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '닉네임'">
                   </div>
                   <div class="box">
                       <input type="text" class="inputPW" maxlength="30" name="explanation"
                       placeholder="한줄소개"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '한줄소개'">
                   </div>
                   <div class="box">
                       <input type="text" class="inputPW" maxlength="30" name="personality"
                       placeholder="성격"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '성격'">
                   </div>
                   
                   <div class="box">
                   	<div class="inputGender">성별</div>
                   	<select name="gender" class="Stype">
                   		<option selected name="F">여</option>
                   		<option name="M">남</option>
                   	</select>
                   </div>
                   <div class="inbodyBox">*InBody 정보</div>
                   <div class="box">
                       <input type="text" class="inputInbody" id="pswd1" maxlength="30"
                       placeholder="키"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '키'">
                   </div>
                   <div class="box">
                       <input type="text" class="inputInbody" id="pswd1" maxlength="30"
                       placeholder="몸무게"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '몸무게'">
                   </div>
                   <div class="box">
                       <input type="text" class="inputInbody" id="pswd1" maxlength="30"
                       placeholder="골격근량"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '골격근량'">
                   </div>
                   <div class="box">
                       <input type="text" class="inputInbody" id="pswd1" maxlength="30"
                       placeholder="체지방률"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '체지방률'">
                   </div>
                   
                   <div class="box">
                       <input type="text" class="inputInbody" id="pswd1" maxlength="30"
                       placeholder="내장지방레벨"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '내장지방레벨'">
                   </div>
                   <div class="box">
                       <input type="date" class="inputInbody" id="pswd1" maxlength="30"
                       placeholder="측정날짜"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '측정날짜'">
                   </div>
               </div>
               <div><button type="button" id="register_btn" onclick="register_check();">회원가입</button></div>
           </div>
       </form>
   </div>
            

<%@ include file="frameFooter.jsp" %>