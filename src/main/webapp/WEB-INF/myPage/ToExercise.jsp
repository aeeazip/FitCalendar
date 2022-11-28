<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ToExercise</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<style>

.done{
	text-decoration: line-through;
}

</style>

</head>
<%@ include file="../frameHeader.jsp"%>
<body>
<div class="mypic">
	<h2>To Exercise List</h2>
</div>
<div class="mybox">
<form name="form" method="POST" action="<c:url value='/mypage/ToExercise/add' />">
		<input name="listItem" class="form-control" type="text"
			placeholder="오늘 할 운동을 추가하세요">
		<button type="submit">추가</button>
</form>
		<c:forEach var="list" items="${ToExerciseList}" varStatus="status">
			<c:if test="${ 'F' eq list.checked }">
				<li>
					<p>✅ ${list.content}
					<form name="deleteForm"action="<c:url value='/mypage/ToExercise/check'/>" method="POST">
					<input type="hidden" name = "itemId" value="${list.itemId}"/>
					<button type="submit" ">do</button>
					</form>
					<form name="deleteForm"action="<c:url value='/mypage/ToExercise/delete'/>" method="POST">
					<input type="hidden" name = "itemId" value="${list.itemId}"/>
					<button type="submit" >삭제하기</button>
					</form>
					</p>
				</li>
			</form>
		</c:if>
			<c:if test="${ 'T' eq list.checked }">
				<li>
					<p class="done">✅${list.content}
					<form name="deleteForm"action="<c:url value='/mypage/ToExercise/uncheck'/>" method="POST">
					<input type="hidden" name = "itemId" value="${list.itemId}"/>
					<button type="submit" ">undo</button>
					</form>
					<form name="deleteForm"action="<c:url value='/mypage/ToExercise/delete'/>" method="POST">
					<input type="hidden" name = "itemId" value="${list.itemId}"/>
					<button type="submit" >삭제하기</button>
					</form>
					</p>
				</li>
				
			</c:if>
		</c:forEach>
				
	</div>
</body>
<%@ include file="../frameFooter.jsp"%>