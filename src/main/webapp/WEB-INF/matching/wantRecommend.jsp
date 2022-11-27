<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>WantRecommend</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css">
<script type="text/javascript">
	function recommend() {
		form.submit();
	}
</script>
</head>
<%@ include file="../frameHeader.jsp"%>
<body>

	<div align="center">
		<form name="startRecommendForm"
			action="<c:url value='/matching/wantRecommend/recommendRequest' />"
			method="POST">
			<h2>
				FitMate 추천을 받고 싶다면 <br> 버튼을 누르세요!
			</h2>
			<br>
			<button type="submit">FitMate Recommend Start!</button>
		</form>
	</div>
</body>

<%@ include file="../frameFooter.jsp"%>
</html>