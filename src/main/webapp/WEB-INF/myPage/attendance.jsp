<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>attendance</title>
    <link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/css/attendance.css' />" type="text/css">
      <script type="text/javascript">
    	function check() {
    		console.log("form submit");
    		form.submit();
    	}
    </script>
</head>


<%@ include file="../frameHeader.jsp" %>

<div id="main">
         <form name="form" method="POST" action="<c:url value='/myPage/attendance' />">
            <div class="flex-container2">
                <div id="subTitle">
                    <p class="subTitle">출석체크</p>
                </div>
                <div id="loginBox">
                    <div class="box">
                    	<p class="info">출석체크 시 5 point가 부여됩니다.</p>
                    	<p class="info2">출석체크 하시겠습니까?</p>
                    	<input type="hidden" name="attendance" value="1" />
                    </div>
                </div>
                <div><button type="button" id="att_btn" onclick="check();">출석체크 하기</button></div>
            <div class="flex-container-icon2">
                       <div class="flex-container-icon-sub1"></div>
                       <div id="out">
                           <button type="button" class="backBtn" onclick="history.back();" style="margin-top:15px">이전으로</button>
                       </div>
             </div>
            </div>
        </form>
    </div>
   

<%@ include file="../frameFooter.jsp" %>