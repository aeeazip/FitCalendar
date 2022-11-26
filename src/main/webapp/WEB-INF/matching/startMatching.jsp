<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>startMatching!!!</title>
   <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align = "center">
<<<<<<< HEAD
   <form name="startMateForm" action="<c:url value='/matching/setMate' />" method="GET">
      <h2>${nickname}님 FitMate 매칭을 시작하시려면 버튼을 클릭해주세요!</h2>
      <button type="submit">매칭 시작하기</button>
   </form>
</div>   
</body>
<%@ include file="../frameFooter.jsp" %>
</html>
=======
	<form name="startMateForm" action="<c:url value='/matching/setMate' />" method="POST">
		<h2>${nickname}님 FitMate 매칭을 시작하시려면 버튼을 클릭해주세요!</h2>
		<button type="submit">매칭 시작하기</button>
	</form>
</div>	
</body>
<%@ include file="../frameFooter.jsp" %>
</html>
>>>>>>> c22ce542531b15f58853bfc823eec677c049056e
