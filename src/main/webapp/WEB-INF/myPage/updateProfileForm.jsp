<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String exerciserid = (String)request.getAttribute("exerciserid");
	String nickname = (String)request.getAttribute("nickname");
	String explanation = (String)request.getAttribute("explanation");
	String personality = (String)request.getAttribute("personality");
	String speciality = (String)request.getAttribute("speciality");
	String gender = (String)request.getAttribute("gender");
	System.out.println("12행 : " + gender);
	
	int height = (int)request.getAttribute("height");
	int weight = (int)request.getAttribute("weight");
	int percentBodyFat = (int)request.getAttribute("percentBodyFat");
	int skeletalMM = (int)request.getAttribute("skeletalMM");
	int visceralFat = (int)request.getAttribute("visceralFat");
	String measureDate = (String)request.getAttribute("measureDate");
	System.out.println("18행 : " + measureDate);
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>updateProfile</title>
    <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/registerForm.css' />" type="text/css">
	<script type="text/javascript">
    	function updateProfile() {
    		if(form.measuredate.value == "") {
    			alert("인바디 측정날짜를 입력하십시오.");
    			form.id.focus();
    			return false;
    		} 
    		console.log("form submit");
    		form.submit();
    	}
    </script>
</head>

<%@ include file="../frameHeader.jsp" %>

	<div id="main">
       <form name="form" method="POST" action="<c:url value='/mypage/profile/update' />">
           <div class="flex-container2">
               <div id="subTitle">
                   <p class="subTitle">Update My Profile</p>
               </div>
               <div id="loginBox">
                   <div class="box">
                   		<p class="theme">닉네임 : </p>
                   		<input type="text" class="updateInfo" maxlength="30" name="nickname" value = "<%= nickname%>">
                   	</div>
                   	 <div class="box">
                   		<p class="theme">한줄소개 : </p>
                   		<input type="text" class="updateInfo" maxlength="30" name="explanation" value = "<%= explanation%>">
                   	</div>
                   	<div class="box">
                   		<p class="theme">성격 : </p>
                   		<input type="text" class="updateInfo" maxlength="30" name="personality" value = "<%= personality%>">
                   	</div>
                   <div class="box">
                   	<div class="updateS">주로 하는 운동 종목</div>
                   	<select name="speciality" class="Stype">
                   	<c:forEach var="speciality" items="${speciality}">
                   		<option value="헬스" 
                   			<c:if test="${speciality eq '헬스'}">selected="selected"</c:if>
                   		>헬스</option>
                   		<option value="요가/필라테스" 
                   			<c:if test="${speciality eq '요가/필라테스'}">selected="selected"</c:if>
                   		>요가/필라테스</option>
                   		<option value="러닝" 
                   			<c:if test="${speciality eq '러닝'}">selected="selected"</c:if>
                   		>러닝</option>
                   		<option value="기타" 
                   			<c:if test="${speciality eq '기타'}">selected="selected"</c:if>
                   		>기타</option>
                  	</c:forEach>
                   	</select>
                   </div>
                   <div class="inbodyBox">*InBody 정보</div>
                   <div class="box">
                   		<p class="theme2">키  : </p>
                   		<input type="text" class="inputInbody" maxlength="30" name="height" value = "<%= height%>">
                   	</div>
                   	<div class="box">
                   		<p class="theme3">몸무게  : </p>
                   		<input type="text" class="inputInbody" maxlength="30" name="weight" value = "<%= weight%>">
                   	</div>
                   	<div class="box">
                   		<p class="theme2">골격근량  : </p>
                   		<input type="text" class="inputInbody" maxlength="30" name="skeletalMM" value = "<%= skeletalMM%>">
                   	</div>
                   	<div class="box">
                   		<p class="theme3">체지방률  : </p>
                   		<input type="text" class="inputInbody" maxlength="30" name="percentBodyFat" value = "<%= percentBodyFat%>">
                   	</div>
                   	<div class="box">
                   		<p class="theme2">내장지방레벨  : </p>
                   		<input type="text" class="inputInbody" maxlength="30" name="visceralFat" value = "<%= visceralFat%>">
                   	</div>
                   <div class="box">
                       <input type="date" class="updateDate" maxlength="30" name="measuredate" >
                   </div>
               </div>
               <div><button type="button" id="register_btn" onclick="updateProfile();">수정하기</button></div>
           		<div class="flex-container-icon2">
                       <div class="flex-container-icon-sub1"></div>
                       <div id="out">
                           <button type="button" class="backBtn" onclick="history.back();" style="margin-top:15px">이전으로</button>
                       </div>
                 </div>
           </div>
       </form>
   </div>

<%@ include file="../frameFooter.jsp" %>