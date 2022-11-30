<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%!
	int count = 1;
%>
	<meta charset="utf-8">
	<title>Fitmate</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
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

		<c:if test="${empty fitmateList}">
		<p class="subTitle" style="font-size:18px; margin-bottom:30px;">현재 요청하신 FitMate가 존재하지 않습니다.</p>
		</c:if>
		<c:if test="${not empty fitmateList}">
		<p class="subTitle" style="font-size:18px; margin-bottom:30px;">FitMate 목록</p>
		
		<div style="text-align: center">
			<form>
				<table id="recordT" style="table-layout: auto; table-layout: fixed;">
				<c:forEach var="list" items="${fitmateList}" varStatus="status">
				
					<tr>
						<td align="left" colspan="2">
							<p class="subTitle" style="display:inline-block; font-size:16px; font-weight: 400; margin-bottom:10px;">No. <%=count %></p>
							<a href="<c:url value='/matching/fitmate/message'>
				     		   <c:param name='fitmateId' value='${list.id}'/>
						 	 </c:url>" class="send_btn">메시지 목록</a>
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
					</c:if>
					</table>
				</form>
			</div>
		</div>
</div>

<%@ include file="../frameFooter.jsp" %>