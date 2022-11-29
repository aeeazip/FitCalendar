<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>matchingMenu!!!</title>
	<link rel="stylesheet" href="<c:url value='../css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/myPageMenu.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
	   <div id="subTitle">
	       <p class="subTitle">${nickname}님의 option정보입니다.</p>
	       <div class="flex-container-icon-sub1 category3">
				<c:if test="${useMatchSvc eq 'T'}">
				<input type="radio" checked>&nbsp;&nbsp;매칭 가능 상태
				</c:if>
				<c:if test="${useMatchSvc eq 'F'}">
				<input type="radio" checked>&nbsp;&nbsp;매칭 불가능 상태
				</c:if>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				원하는 fitmate 수 : ${maxMate}명
			</div>
	   </div>
	   

			<div id="main" style="padding-bottom: 30px;">
                    <div class="flex-container2">
                        <!-- 메인 -->
                        <div>
                             
                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                   <a href="./getRecommendList">
                                        <div class="category2">요청받은 fitmate</div>  </a>
                                </div>
                            </div>

                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                               		<a href="./wantRecommend">
                                        <div class="category2">FITMATE RECOMMEND</div> </a>
                                </div>
                            </div>

                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                    <a href="./situation/list">
                                        <div class="category2">요청 상태 관리</div> </a>
                                </div>
                            </div>
                            
                            <div class="flex-container-icon">
                                <div class="flex-container-icon-sub1">
                                    <a href="./setOptions">
                                        <div class="category2">옵션 바꾸기</div>  </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                

<%@ include file="../frameFooter.jsp" %>
