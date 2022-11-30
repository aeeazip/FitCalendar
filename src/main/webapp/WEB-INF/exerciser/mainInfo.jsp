<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>mainInfo</title>
</head>
	   <div id="subTitle" align = "center">
	       <p class="subTitle">안녕하세요 ${nickname}님!</p>
	       <br><br>
	       	FitCalendar를 방문해주셔서 감사합니다!
	       <br><br><br>
			현재 보유 포인트 : ${point }
			<br><br><br>
			한줄 소개 : ${ explanation}
			<br><br><br>
			성별 : 
			<c:if test="${gender eq 'M' }">남자</c:if>
			<c:if test="${gender eq 'F' }">여자</c:if>
		</div>      