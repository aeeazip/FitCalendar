<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>static</title>
    <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/static.css' />" type="text/css">
</head>

<%@ include file="../frameHeader.jsp" %>

				<div id="subTitle" >
                 	<p class="subTitle">My Statics</p>
                </div>

                <div id="main">
                    <div class="flex-container2">
                        <!-- 메인 -->
                        <div>
                            
                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                        <div class="category2">이번주 운동 횟수</div> 
                                </div>
                            </div>

                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                        <div class="category2">이번달 운동 횟수</div> 
                                </div>
                            </div>

                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                        <div class="category2">ToExerciseList</div> 
                                </div>
                            </div>

                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                        <div class="category2">My Statics</div>
                                </div>
                            </div>
                            
                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                        <div class="category2">Settings</div> 
                                </div>
                                    
                            </div>

                            <div class="flex-container-icon2">
                                <div class="flex-container-icon-sub1"></div>
                                <div id="out">
                                    <button type="button" onclick="history.back();">이전으로</button>
                                </div>
                            </div>

                            
                        </div>
                    </div>
                </div>

<%@ include file="../frameFooter.jsp" %>