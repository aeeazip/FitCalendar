<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Record"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Record record = (Record) request.getAttribute("record");
String nickname = (String) request.getAttribute("nickname");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Running Category Record</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">
	
	<script>
		function recordRemove() {
			return confirm("정말 삭제하시겠습니까?");
		}
	</script>
	<style>
	 	#recordT { 
	 		border-top: 1px solid #414141; 
	 		border-collapse: collapse; 
	 	} 
		
	 	td { padding: 10px 0; } 
	 	
	 	#wrapper .container {
		    width: 580px;
		    margin: 0 auto;
		    margin-bottom: 80px;
		}
 	</style>
</head>
	<%@ include file="../../frameHeader.jsp"%>

	<div id="main" >
	<div class="flex-container2">
		<div style="text-align: center">
			<form>
				<table id="recordT" style="table-layout: auto; table-layout: fixed;">
					
					<tr>
						<td align="center" width="150" bgcolor="E6ECDE" height="40" class="a" style="border-top: 1px solid black;">RecordId</td>
						<td bgcolor="ffffff" class="a" style="border-top: 1px solid black;">&nbsp;&nbsp;&nbsp;&nbsp;<%=record.getRecordId()%>
						</td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="40" class="a">제목</td>
						<td bgcolor="ffffff" class="b">&nbsp;&nbsp;&nbsp;&nbsp;<%=record.getTitle()%>
						</td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="40" class="a">날짜</td>
						<td bgcolor="ffffff" class="b">
							&nbsp;&nbsp;&nbsp;&nbsp;${record.creationDate}</td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="40" class="a">운동
							종류</td>
						<td bgcolor="ffffff" class="b">&nbsp;&nbsp;&nbsp;&nbsp;러닝</td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="40" class="a">총
							운동시간</td>
						<td bgcolor="ffffff" class="b">&nbsp;&nbsp;&nbsp;&nbsp;${record.totalTime}</td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="40" class="a">운동
							루틴</td>
						<td bgcolor="ffffff" class="b">&nbsp;&nbsp;&nbsp;&nbsp;${record.routine}</td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="40" class="a">운동
							식단</td>
						<td bgcolor="ffffff" class="b">&nbsp;&nbsp;&nbsp;&nbsp;${record.diet}</td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="200" class="a">사진</td>
						<td bgcolor="ffffff" class="b"><c:if test="${!empty record.photo}">
								<img height="300px" src="<c:url value='/upload/${record.photo}'/>" />
							</c:if>
						</td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="40" class="a">공유
							허용</td>
						<td bgcolor="ffffff" class="b"><c:if
								test="${record.shareOption eq '1'}">
								<p>&nbsp;&nbsp;&nbsp;&nbsp;예</p>
							</c:if> <c:if test="${record.shareOption eq '0'}">
								<p>&nbsp;&nbsp;&nbsp;&nbsp;아니요</p>
							</c:if></td>
					</tr>
					<tr>
						<td align="center" bgcolor="E6ECDE" height="40" class="a">작성자</td>
						<td bgcolor="ffffff" class="b">&nbsp;&nbsp;&nbsp;&nbsp;${nickname}</td>
					</tr>
				</table>
				</form>


			<!-- 수정 및 삭제 -->
				<div style="text-align: center;">
					<a
						href="<c:url value='/myRecord/update'>
				     		   <c:param name='recordId' value='<%=String.valueOf(record.getRecordId())%>'/>
						 	 </c:url>" class="update_btn">수정</a>
					&nbsp; <a
						href="<c:url value='/myRecord/delete'>
							   <c:param name='recordId' value='<%=String.valueOf(record.getRecordId())%>'/>
						 	 </c:url>" class="delete_btn"
						onclick="return recordRemove();">삭제</a> &nbsp; 
				</div>

			<!-- 목록 -->
			<form action="<c:url value='/myRecord/list' />" method="GET">
					<button type="submit" class="golist_btn">목록으로 돌아가기</button>
			</form>
			
		</div>
	</div>
</div>
	

	<%@ include file="../../frameFooter.jsp"%>