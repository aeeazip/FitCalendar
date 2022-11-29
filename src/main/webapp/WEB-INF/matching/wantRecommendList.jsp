<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>RecommendList</title>
	<link rel="stylesheet" href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<%
		String fitmateId = (String)request.getAttribute("recommId");
		session.setAttribute("fitMateId",fitmateId);
		System.out.println(fitmateId);
	%>

</head>
<%@ include file="../frameHeader.jsp"%>

	<div id="main">
	<div class="flex-container2">
		<div id="subTitle" >
           <p class="subTitle" style="font-size:18px; margin-bottom:30px;">FitMate 추천 결과입니다</p>
      	 </div>
      	 
		<div style="text-align: center">
				<form>
					<table style="table-layout: auto; table-layout: fixed;">
							<tr>
								<td class="a" style="border-top: 1px solid black;">NickName</td>
								<td class="b" style="border-top: 1px solid black;">${recomm.nickname}</td>
							</tr>
							<tr>
								<td class="a">성별</td>
								<td class="b">${recomm.gender}</td>
							</tr>
							<tr>
								<td class="a">운동 주종목</td>
								<td class="b">${recomm.speciality}</td>
							</tr>
							<tr>
								<td class="a">한줄 소개</td>
								<td class="b">${recomm.explanation}</td>
							</tr>
							<tr>
								<td class="a">성격</td>
								<td class="b">${recomm.personality}</td>
							</tr>
					</table>
				</form>
				
		<form name="startMateForm" action="<c:url value='/matching/wantRecommend/list/request' />"
			method="POST">
			<button type="submit" class="fitmatelist_btn">Fitmate 요청 보내기</button>
		</form>
		
		<form name="startMateForm" 
			action="<c:url value='/matching/wantRecommend/list/reRequest' />"
			method="POST">
			<button type="submit" class="fitmatelist_btn">재추천 받기</button>
		</form>

	</div>
	
</div>
</div>
<%@ include file="../frameFooter.jsp"%>
