<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Mypage Category</title>
</head>
<body>
	<div class="list-group">
		<a href="<c:url value='/mypage/profile/update'>
  	 	<c:param name='id' value='hjid'/>
  	 	</c:url>" class="list-group-item list-group-item-action">프로필 수정</a>
  	 	<a href="#" class="list-group-item list-group-item-action">출석 체크</a> 
  	 	<a href="#" class="list-group-item list-group-item-action">ToExercise</a> 
	 	<a href="#" class="list-group-item list-group-item-action">View Static</a> 
	</div>
</body>
</html>