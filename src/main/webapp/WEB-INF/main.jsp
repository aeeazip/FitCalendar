<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
	<%!int count = 1;%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FitCalendar</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">
	<link rel="stylesheet" type="text/css" href="bootstrap-3.3.2-dist/css/bootstrap.min.css" />
	<style>
	 	#recordT { 
	 		border-collapse: collapse; 
	 	} 
		
 	</style>
</head>

<%@ include file="frameHeader.jsp"%>

<div id="main">
           <div class="flex-container2 ">

			<c:if test="${!empty exerciser}">
				<div id="subTitle">
                   <p class="subTitle" style="font-size:18px; margin-bottom:10px;">안녕하세요 ${nickname} 님,</p>
                   <p class="subTitle" style="font-size:18px; margin-bottom:10px;">FitCalendar를 방문해주셔서 감사합니다!</p>
                   <p class="subTitle" style="font-size:16px; margin-bottom:10px;">현재 보유 포인트 : ${point }</p>
                   <p class="subTitle" style="font-size:16px; margin-bottom:60px;">한줄 소개 : ${ explanation}</p>
                   <p class="subTitle" style="font-size:16px; margin-bottom:10px;">포인트 랭킹</p>
               </div>

		<!-- 포인트 상위 랭킹 -->
		<div style="text-align: center">
			<form>
				<table id="recordT" style="table-layout: auto; table-layout: fixed;">
					
					<tr>
						<td align="center" bgcolor="E6ECDE" height="30"  class="a" style="border-top: 1px solid black;">등수</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">닉네임</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">보유 포인트</td>
					</tr>
					<c:forEach var="ranking" items="${rankingList}">
					<tr>
						<td bgcolor="ffffff" height="30"  class="a" style="border-top: 1px solid black;"><%=count++ %>등</td>
						<td bgcolor="ffffff" class="b" style="border-top: 1px solid black;"><c:out value="${ranking.nickname}" /></td>
						<td bgcolor="ffffff" class="a" style="border-top: 1px solid black;"><c:out value="${ranking.point}" /></td>
					</tr>
					
					</c:forEach>
					<%
					count = 1;
					%>
				</table>
			</form>
		</div>
</c:if>


<c:if test="${empty exerciser}">
	<div id="subTitle" align="center">
		<p class="subTitle" style="font-size:18px; margin-bottom:10px;">FitCalendar를 방문해주셔서 감사합니다.</p>
		<p class="subTitle" style="font-size:18px; margin-bottom:10px;">로그인을 해주세요 !</p>
	</div>
</c:if>


</div>
</div>

<%@ include file="frameFooter.jsp"%>