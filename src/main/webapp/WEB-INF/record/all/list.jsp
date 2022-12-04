<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.Record" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>AllRecord</title>
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
 	</style>
</head>

	<%
		List<Record> recordList = (List<Record>) request.getAttribute("recordList");
		List<String> nickNameList = (List<String>)request.getAttribute("nickNameList");
		String category = (String)request.getAttribute("category");
		String pageT = (String) request.getAttribute("totalP");
		String currentP = (String)request.getAttribute("currentPage");
		System.out.println(currentP);
		
		int recordId;
		int i = 0;
		
		if(currentP == null){
			recordId = 1;
		}	
		else{
			recordId = (Integer.parseInt(currentP) - 1)*5 + 1;
		}
	%>
	
	
<%@ include file="../../frameHeader.jsp"%>

	
<div id="main">
	<div class="flex-container2">
		<div id="subTitle" >
			<p class="subTitle" style="font-size:18px; margin-bottom:10px;">전체 운동 기록</p>
			<p class="subTitle" style="font-size:14px; margin-bottom:30px;">제목을 클릭하면 기록이 보여요 !</p>
		</div>
			
			
		<div style="text-align: center">
			<form>
				<table id="recordT" style="table-layout: auto; table-layout: fixed;">
					<tr>
						<td align="center" bgcolor="E6ECDE" height="50"  class="a" style="border-top: 1px solid black;">글 번호</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">제목</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">분류</td>
						<td align="center" bgcolor="E6ECDE" class="a" style="border-top: 1px solid black;">작성자</td>
					</tr>
					<c:forEach var="record" items="${recordList}">
					<tr>
							<td align="center" bgcolor="ffffff" height="35" class="a">
								<%= recordId++ %></td>
							<td bgcolor="ffffff"  class="b">
								<a href="<c:url value='/allRecord/list/detail'><c:param name='recordId' value='${record.recordId}'/></c:url>">${record.title}</a>
							</td>
							<td bgcolor="ffffff" align="center" class="a"><c:if
									test="${record.category eq '1'}">
									<p>헬스</p>
								</c:if> <c:if test="${record.category eq '2'}">
									<p>필라테스</p>
								</c:if> <c:if test="${record.category eq '3'}">
									<p>요가</p>
								</c:if> <c:if test="${record.category eq '4'}">
									<p>러닝</p>
								</c:if> <c:if test="${record.category eq '5'}">
									<p>기타</p>
								</c:if></td>
							<td bgcolor="ffffff" align="center" class="b"><%=nickNameList.get(i++) %></td>
						</tr>
					</c:forEach>
				</table>
			</form>		
		</div>
		<br><br>
		<div style="text-align: center">
				<%
					for(int j=1; j<=Integer.parseInt(pageT); j++){
						String str = String.valueOf(j);
				%>
				<a href="<c:url value='/allRecord/list'><c:param name='currentPage' value='<%= str %>'/></c:url>"><%= j %></a>
				<%
				}
				%>
		</div>
	</div>
</div>

	<%@ include file="../../frameFooter.jsp"%>