<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>ToExercise</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/ToExercise.css' />" type="text/css">
	<style>
	
	.done{
		text-decoration: line-through;
	}
	
	</style>

</head>
<%@ include file="../frameHeader.jsp"%>

<div id="main">
	 <div id="subTitle">
          <p class="subTitle">To Exercise List</p>
     </div>
	<div class="mybox">
	<form name="form" method="POST" action="<c:url value='/mypage/ToExercise/add' />">
			<input type="text" name="listItem" class="input" 
				placeholder="오늘 할 운동을 추가하세요"
				onfocus="this.placeholder = ''" 
                onblur="this.placeholder = '오늘 할 운동을 추가하세요'">
				
                        
			<button type="submit" class="toBtn">추가</button>
	</form>
	
			<c:forEach var="list" items="${ToExerciseList}" varStatus="status">
				<c:if test="${ 'F' eq list.checked }">
					<li>
						<p class="listText">✅ ${list.content} <br><br>
						<form name="deleteForm"action="<c:url value='/mypage/ToExercise/check'/>" class="btnForm"  method="POST">
						<input type="hidden" name = "itemId" value="${list.itemId}" class="listText" />
						<button type="submit" class="toBtn" >do</button>
						</form>
						
						<form name="deleteForm"action="<c:url value='/mypage/ToExercise/delete'/>" class="btnForm" method="POST">
						<input type="hidden" name = "itemId" value="${list.itemId}" class="listText" />
						<button type="submit" class="toBtn" >삭제하기</button>
						</form>
						</p>
					</li>
				</form>
			</c:if>
				<c:if test="${ 'T' eq list.checked }">
					<li>
						<p class="done listText">✅${list.content} <br><br>
						<form name="deleteForm" action="<c:url value='/mypage/ToExercise/uncheck'/>" class="btnForm" method="POST">
						<input type="hidden" name = "itemId" value="${list.itemId}"/>
						<button type="submit" class="toBtn">undo</button>
						</form>
						
						<form name="deleteForm" action="<c:url value='/mypage/ToExercise/delete'/>" class="btnForm"  method="POST">
						<input type="hidden" name = "itemId" value="${list.itemId}"  />
						<button type="submit" class="toBtn" >삭제하기</button>
						</form>
						</p>
					</li>
					
				</c:if>
			</c:forEach>
					
		</div>
		 <div class="flex-container-icon2">
                       <div class="flex-container-icon-sub1"></div>
                       <div id="out">
                           <button type="button" class="backBtn" onclick="location.href = '../myPage';" style="margin-top:15px">이전으로</button>
                       </div>
             </div>
</div>
<%@ include file="../frameFooter.jsp"%>