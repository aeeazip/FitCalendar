<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<%!
	int count = 1;
%>

   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>Matching request processing!!!</title>
   <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
   <link rel="stylesheet" href="<c:url value='/css/startMatching.css' />" type="text/css">

</head>
<%@ include file="../frameHeader.jsp" %>

<div id="main">
	<div class="flex-container2">
		<div id="subTitle" >
           <p class="subTitle" style="font-size:18px; margin-bottom:30px;">나에게 요청을 보낸 예비 Fitmate입니다!<br>수락/거절을 하세요!</p>
      	 </div>
	
	<c:if test="${empty getRecommList}">
	<p class="subTitle" style="font-size:18px; margin-bottom:30px;">현재 getRecommList가 없습니다. </p>
	</c:if>
	<c:if test="${not empty getRecommList}">
	<table>
		<c:forEach var = "list" items="${getRecommList}" varStatus="status">
		<form name="submitform" method="POST" action="<c:url value='/matching/getRecommendList/accept'/>">
		<tr>
			<td>
				No. <%=count %>
				<p>닉네임: <c:out value="${list.nickname}" />
				<p>한줄소개: <c:out value="${list.explanation}" />
				<p>운동종목 : <c:out value="${list.speciality}" />
				<p>성격 : <c:out value="${list.personality}" />
				<p>성별 : <c:out value="${list.gender}" />
			</td>
			<td>
				<form name="acceptForm"action="<c:url value='/matching/getRecommendList/accept'/>" method="POST">
				<input type="hidden" name = "fitmateId" value="${list.id}"/>
				<button type="submit"  style="padding:3px; background-color: #A2C2B3; border-radius: 5px; border: none;">수락하기</button>
				</form>
				<br><br>
				<form name="refuseForm"action="<c:url value='/matching/getRecommendList/refuse'/>" method="POST">
				<input type="hidden" name = "fitmateId" value="${list.id}"/>
				<button type="submit"  style="padding:3px; background-color: #A2C2B3; border-radius: 5px; border: none;">거절하기</button>
				</form>
				
			</td>
		</tr>
		</form>
		<%count++; %>
		</c:forEach>
		<%count = 1; %>
	</table>
   	</c:if>
   	
   			<form name="startMateForm"
				action="<c:url value='/matching/matchingMenu' />" method="GET">
				<button type="submit" class="fitmatelist_btn" style="margin-left:30px" >menu 화면으로 돌아가기</button>
			</form>
</div>   
</div>
<%@ include file="../frameFooter.jsp" %>
