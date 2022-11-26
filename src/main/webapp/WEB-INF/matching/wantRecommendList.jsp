<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RecommendList</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/css/wantRecommendList.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align ="center">
<h3>추천 FitMate</h3>
<table>
    <tr>
      <td>NickName</td>
      <td>${recomm.nickname}</td>
    </tr>
    <tr>
      <td>성별</td>
      <td>${recomm.gender}</td>
    </tr>
    <tr>
      <td>운동 주종목</td>
      <td>${recomm.speciality}</td>
    </tr>
    <tr>
      <td>한줄 소개</td>
      <td>${recomm.explanation}</td>
    </tr>
    <tr>
      <td>성격</td>
      <td>${recomm.personality}</td>
    </tr>
  </table>
  <br><br>
  <input type="submit" value="FitMate 신청" formaction="/matching/wantRecommend/list/request">&nbsp; &nbsp; &nbsp; &nbsp; 
  <input type="submit" value="재추천" formaction="/matching/wantRecommend/list/reRequest">
  </div>
</body>

<%@ include file="../frameFooter.jsp" %>
</html>