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
	<link rel="stylesheet" href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">
	<style>
	 	#recordT { 
	 		border-collapse: collapse; 
	 	} 
		
 	</style>
</head>
<%@ include file="../frameHeader.jsp" %>

<div id="main">
	<div class="flex-container2">
	
	<c:if test="${!empty getRecommList}">
		<div id="subTitle" >
           <p class="subTitle" style="font-size:18px; margin-bottom:30px;">나에게 요청을 보낸 예비 Fitmate입니다!<br>수락/거절을 해주세요.</p>
      	 </div>
	</c:if>
	
	<c:if test="${empty getRecommList}">
	<p class="subTitle" style="font-size:18px; margin-bottom:30px;">현재 요청받은 Fitmate가 없습니다. </p>
	</c:if>
	<c:if test="${not empty getRecommList}">
		<div style="text-align: center">
			<form name="submitform" method="POST" action="<c:url value='/matching/getRecommendList/accept'/>">
				<table id="recordT" style="table-layout: auto; table-layout: fixed;">
					<c:forEach var = "list" items="${getRecommList}" varStatus="status">
					<tr>
						<td align="left" colspan="4">
							<p class="subTitle" style="display:inline-block; font-size:16px; font-weight: 400; margin-bottom:10px;">No. <%=count %></p>
							
							<a href="<c:url value='/matching/getRecommendList/accept'>
				     		   <c:param name='fitmateId' value='${list.id}'/>
						 	 </c:url>" class="send_btn">수락하기</a>
						 	 
						 	 <a href="<c:url value='/matching/getRecommendList/refuse'>
				     		   <c:param name='fitmateId' value='${list.id}'/>
						 	 </c:url>" class="send_btn">거절하기</a>
						 </td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="30"  class="a" style="border-top: 1px solid black;">닉네임</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">한줄소개</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">운동종목</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">성격</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">성별</td>
					</tr>
					<tr>
						<td bgcolor="ffffff" height="30"  class="a" style="border-top: 1px solid black;"><c:out value="${list.nickname}" /></td>
						<td bgcolor="ffffff" class="b" style="border-top: 1px solid black;"><c:out value="${list.explanation}" /></td>
						<td bgcolor="ffffff" class="a" style="border-top: 1px solid black;"><c:out value="${list.speciality}" /></td>
						<td bgcolor="ffffff" class="b" style="border-top: 1px solid black;"><c:out value="${list.personality}" /></td>
						<td bgcolor="ffffff" class="a" style="border-top: 1px solid black;"> <c:out value="${list.gender}" /></td>
					</tr>
					<%count++; %>
					</c:forEach>
					<%count = 1; %>
					</table>
				</form></div>
   			</c:if>
			</div> 
			
   			<form name="startMateForm"
				action="<c:url value='/matching/matchingMenu' />" method="GET">
				<button type="submit" class="fitmatelist_btn" style="margin-top:35px; margin-left:150px;">menu 화면으로 돌아가기</button>
			</form>
</div>
<%@ include file="../frameFooter.jsp" %>
