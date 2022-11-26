<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>matchingMenu!!!</title>
	<link rel="stylesheet" href="<c:url value='../css/frame.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>

<div>
	<form name="matchingMenu" action="setMaxMate.jsp" method="POST">
		<input type="text" value = "${exerciser.exerciserId} }">
		<input type="text" value = "${exerciser.useMatchSvc} }">
		
		<input type="button" onclick="location='getRecommendList.jsp'" value = "">
		<input type="button" onclick="location='wantRecommendForm.jsp'" value = "">
		<input type="button" onclick="location='situation.jsp'" value = "">
		<input type="button" onclick="location='changeOption.jsp'" value = "">
	</form>
</div>

<%@ include file="../frameFooter.jsp" %>
</html>