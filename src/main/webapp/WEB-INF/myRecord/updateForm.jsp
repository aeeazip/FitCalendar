<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Record"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>recordForm</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/recordForm.css' />" type="text/css">
	 <link rel="stylesheet" href="<c:url value='/css/registerForm.css' />" type="text/css">

<%
Record record = (Record) request.getAttribute("record");
%>
		<script type="text/javascript">
		function signUpCheck() {
			if (document.getElementById("title").value == "") {
				alert("제목을 입력하십시오.");
				document.getElementById("title").focus();
				return false;
			}
			if (document.getElementById("creationDate").value == "") {
				alert("생성 날짜를 입력하십시오.");
				document.getElementById("creationDate").focus();
				return false;
			}
			if (document.getElementById("totalTime").value == "") {
				alert("총 운동 시간을 입력하십시오.");
				document.getElementById("totalTime").focus();
				return false;
			}
			if (document.getElementById("routine").value == "") {
				alert("운동 루틴을 입력하십시오.");
				document.getElementById("routine").focus();
				return false;
			}
			if (document.getElementById("diet").value == "") {
				alert("식단을 입력하십시오.");
				document.getElementById("diet").focus();
				return false;
			}
			console.log("form submit");
			form.submit();
		}
	</script>
</head>

	<%@ include file="../frameHeader.jsp"%>
	
	
	<input type="hidden" name="test" value="${record.recordId}" />
	
	
<div id="main">
		<form name="form" method="POST" action="<c:url value='/myRecord/update' />" enctype="multipart/form-data">
           <div class="flex-container2 ">
               <div id="subTitle">
                   <p class="subTitle" style="font-size:18px; margin-bottom:50px;">${NickName} 님의 운동 기록</p>
               </div>
               
                <div id="loginBox">
                   <div class="box">
                       <input type="text" class="inputRecord" name="title" id="title" 
                       placeholder="제목을 입력해 주세요."
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '제목을 입력해 주세요.'" value="${record.title}">
                	</div>
                	 <div class="box">
		                <%
							String d = record.getCreationDate();
							String str = d.substring(0, 10);
						%>
                       <input type="date" class="inputRecord"  name="creationDate" id="creationDate" value="<%=str%>" >
                   	</div>
                   	<div class="box">
                       <input type="text" class="inputRecord" name="totalTime" id="totalTime"
                       placeholder="총 운동시간을 입력해 주세요. (예: 3)"
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '총 운동시간을 입력해 주세요. (예: 3)'" value="${record.totalTime}">
                   </div>
                   <div class="box">
                   	<div class=inputSS>운동 종목</div>
                   		<select name="category" id="category" class="Stype" >
                   			<option value="1" selected>헬스</option>
							<option value="2">필라테스</option>
							<option value="3">요가</option>
							<option value="4">러닝</option>
							<option value="5">기타</option>
                   		</select>
                   </div>
                   <div class="box">
                       <textarea rows="5"  class="Qtype4" name="routine" id="routine"
                       placeholder="운동 루틴을 입력하세요."
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '운동 루틴을 입력하세요.'">${record.routine}</textarea>
                   </div>
                   <div class="box">
                       <textarea rows="5"  class="Qtype4" name="diet" id="diet"
                       placeholder="식단을 입력하세요."
                       onfocus="this.placeholder = ''" 
                       onblur="this.placeholder = '식단을 입력하세요.'">${record.diet}</textarea>
                   </div>
                   <div class="box">
                       <input type="file" class="inputRecord" name="photo" id="photo" multiple="multiple">
                   </div>
                   <div class="box">
	                   	<div class="inputRR">기록 공유를 하시겠습니까?</div>
	                   		<select name="shareOption" class="Stype" id="shareOption">
								<option value="1" >예</option>
								<option value="0">아니오</option>
	                   		</select>
	                  </div>
					</div>
					<div><button type="button" id="record_btn" onclick="signUpCheck();">수정하기</button></div>
				</div>
		</form>
	</div>

	<!-- footer -->
	<%@ include file="../frameFooter.jsp"%>