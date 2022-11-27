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
.mypic {
	width: 100%;
	height: 200px;
	background-size: cover;
	color: white;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.mypic>h1 {
	font-size: 30px;
}

.mybox {
	width: 95%;
	max-width: 700px;
	padding: 20px;
	box-shadow: 0px 0px 10px 0px lightblue;
	margin: 20px auto;
}

.mybucket {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: space-between;
}

.mybucket>input {
	width: 70%;
}

.mybox>li {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	margin-bottom: 10px;
	min-height: 48px;
}

.mybox>li>h2 {
	max-width: 75%;
	font-size: 20px;
	font-weight: 500;
	margin-right: auto;
	margin-bottom: 0px;
}

.mybox>li>h2.done {
	text-decoration: line-through
}
</style>

<script>
function save_list(content){
	form.submit();
}

function done_list(itemId){
	form.action = "<c:url value='/mypage/toExercise/check'/>";
	session.setAttribute("itemId", itemId);
	form.submit();
}

function undo_list(itemId){
	form.action = "<c:url value='/mypage/toExercise/unCheck' />";
	session.setAttribute("itemId", itemId);
	form.submit();
}

function delete_list(itemId){
	form.action = "<c:url value='/mypage/toExercise/delete' />";
	session.setAttribute("itemId", itemId);
	form.submit();
}

</script>
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
		<button onclick="save_list()" type="button"
			class="btn btn-outline-primary">추가</button>
</form>
		<c:forEach var="list" items="${ToExerciseList}" varStatus="status">
			<c:if test="${ T eq list.checked }">
				<li>
					<h2>✅ ${list.content}</h2>
					<button onclick="done_list(${list.itemid})" type="button"
						class="btn btn-outline-primary">완료!</button>
				</li>`
		</c:if>
			<c:if test="${ T eq list.checked }">
				<li>
					<h2 class="done">✅${list.content}</h2>
					<button onclick="undo_list(${list.itemid})" type="button"
						class="btn btn-outline-danger">취소</button>
				</li>

			</c:if>
		</c:forEach>

	</div>
</body>
<%@ include file="../frameFooter.jsp"%>