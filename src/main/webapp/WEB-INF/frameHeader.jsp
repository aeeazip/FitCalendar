<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<div class="flex-container">
        <div id="wrapper">
            <!-- header -->
            <div class="header">
            
            <% 
            	HttpSession s = request.getSession();
            	String id = (String)s.getAttribute("id"); 
            %>
                
                <!-- 로그인, 회원가입 -->
                <div id="userMenu">
                    <ul class="list_menu">
                        <li class="menu menu_login">
                        <% if (id == null) { %>
                            <a class="link link_login" href="<c:url value='/exerciser/login' />">로그인</a>
                        <% } else { %>
                            <a class="link link_logout" href="<c:url value='/exerciser/logout' />" >로그아웃</a>
                        <% } %>
                        </li>
                        <li class="menu menu_join">
                            <a class="link link_join" href="<c:url value='/exerciser/register' />">회원가입</a>
                        </li>
                    </ul>
                </div>

                <!-- 로고 -->
                <div id="headerLogo" class="layout-wrapper">
                    <h1 class="logo">
                        <a class="link_main" href="<c:url value='/main' />">
                            <p class="logo">Fit Calendar</p>
                        </a>
                    </h1>
                </div>

                <!-- 메뉴바 -->
                <div class="gnb_main">
                    <ul class="gnb">
                        <li class="menu1">
                            <a href="<c:url value='/myRecord/list' />" class="link all" >나의 기록</a>
                        <li class="menu2">
                            <a href="<c:url value='/allRecord/list' />" class="link new">운동 기록</a>
                        </li>
                        <li class="menu3">
                            <a href="<c:url value='/matching/fitmate' />" class="link best">Fit Mate</a>
                        </li>
                        <li class="menu4">
                            <a href="<c:url value='/matching/startMatching' />" class="link bargain">추천/매칭</a>
                        </li>
                        <li class="menu5">
                            <a href="<c:url value='/myPage' />" class="link event">마이페이지</a>
                        </li>
                    </ul>
                </div>
                
            </div>
            <!-- container -->
            <div class="container">