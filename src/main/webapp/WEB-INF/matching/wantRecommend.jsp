<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WantRecommend</title>
</head>

<body>

<form name="wantRecommend" action='/matching/wantRecommendList.jsp'>
  <h2>FitMate 추천 목록을 보고 싶다면 버튼을 누르세요!</h2>
  <input type='button'  value='추천 시작'onclick=submit()/>
</form>

</body>
</html>