<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>myPageMenu</title>
    <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/myPageMenu.css' />" type="text/css">
</head>

<%@ include file="../frameHeader.jsp" %>


                <div id="subTitle" >
                    <p class="subTitle">마이 페이지</p>
                </div>

                <div id="main">
                    <div class="flex-container2">
                        <!-- 메인 -->
                        <div>
                            
                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                   <a href="<c:url value='/myPage/attendance' />">
                                        <div class="category2">출석</div>  </a>
                                </div>
                            </div>

                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                               		<a href="<c:url value='/mypage/ToExercise' />">
                                        <div class="category2">ToExerciseList</div> </a>
                                </div>
                            </div>

                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                    <a href="<c:url value='/myPage/static' />">
                                        <div class="category2">My Statics</div> </a>
                                </div>
                            </div>
                            
                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                    <a href="<c:url value='/myPage/profile' />">
                                        <div class="category2">My Profile</div>  </a>
                                </div>
                            </div>
                            
                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                    <a href="<c:url value='/mypage/profile/update' />">
                                        <div class="category2">Update My Profile</div> </a>
                                </div>
                                    
                            </div>

                            <div class="flex-container-icon2">
                                <div class="flex-container-icon-sub1"></div>
	                                <a href="<c:url value='/mypage/delete/form' />">
	                                 <div class="category2 delete" >회원탈퇴</div> </a>
                            </div>

                            
                        </div>
                    </div>
                </div>
                

<%@ include file="../frameFooter.jsp" %>
