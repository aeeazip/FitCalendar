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
	<title>profile</title>
    <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/registerForm.css' />" type="text/css">
</head>

<%@ include file="../frameHeader.jsp" %>

	<div id="main">
       <form name="form" >
           <div class="flex-container2">
               <div id="subTitle">
                   <p class="subTitle">My Profile</p>
               </div>
               <div id="loginBox">
                   <div class="box">
                       <p class="inputInfo">아이디 : <%= exerciserid%></p>
                   </div>
                   <div class="box">
                   		<p class="inputInfo">닉네임 : <%= nickname%></p>
                   </div>
                   <div class="box">
                   		<p class="inputInfo">한줄소개 : <%= explanation%></p>
                   </div>
                   <div class="box">
                   		<p class="inputInfo">성격 : <%= personality%></p>
                   </div>
                   <div class="box">
                   		<p class="inputInfo">주로 하는 운동 종목 : <%= speciality%></p>
                   </div>
                   <div class="box">
                   		<p class="inputInfo">성별 : <%= gender%></p>
                   </div>
                   <div class="inbodyBox">*InBody 정보</div>
                   <div class="box">
                       <p class="viewInbody">키 : <%= height%></p>
                   </div>
                   <div class="box">
                       <p class="viewInbody">몸무게 : <%= weight%></p>
                   </div>
                   <div class="box">
                       <p class="viewInbody">골격근량 : <%= skeletalMM%></p>
                   </div>
                   <div class="box">
                       <p class="viewInbody">체지방률 : <%= percentBodyFat%></p>
                   </div>
                   
                   <div class="box">
                       <p class="viewInbody">내장지방레벨 : <%= visceralFat%></p>
                   </div>
                   <div class="box">
                       <p class="viewInbody">측정날짜 : <%= measureDate%></p>
                   </div>
               </div>
                <div class="flex-container-icon2">
                       <div class="flex-container-icon-sub1"></div>
                       <div id="out">
                           <button type="button" class="backBtn" onclick="history.back();">이전으로</button>
                       </div>
                 </div>
           </div>
       </form>
   </div>
            

<%@ include file="../frameFooter.jsp" %>
