<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <title>startMatching!!!</title>
   <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">

 <script type="text/javascript">
    	function start() {
    		form.submit();
    	}
</script>

</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align = "center">

   <form name="startMateForm" action="<c:url value='/matching/setMate' />" method="POST">
      <h3>${nickname}님 FitMate 매칭을 시작하고 싶으시다면
      <br>버튼을 클릭해주세요!</h3>
      <button type="submit">매칭 시작하기</button>
   </form>
</div>   
</body>
<%@ include file="../frameFooter.jsp" %>
