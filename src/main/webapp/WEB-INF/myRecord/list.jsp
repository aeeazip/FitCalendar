<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="EUC-KR">
<title>myRecord</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />"
	type="text/css" />
<link rel="stylesheet"
	href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">

<style>
#recordT {
	border-top: 1px solid #414141;
	border-collapse: collapse;
}

td {
	padding: 10px 0;
}
</style>

</head>
<%@ include file="../frameHeader.jsp"%>

<div id="main">
	<div class="flex-container2">
		<div id="subTitle">
			<p class="subTitle" style="font-size: 18px; margin-bottom: 10px;">나의
				운동 기록</p>
			<p class="subTitle" style="font-size: 14px; margin-bottom: 30px;">제목을
				클릭하면 기록이 보여요 !</p>
		</div>

		<%
			String pageT = (String) request.getAttribute("totalPage");
			String currentP = (String)request.getAttribute("currentPage");
			
			int recordId;
			
			// 화면에 출력할 Record 개수를 5개로 설정 -> *5 해주는 것!! (ex. 10개씩 출력하고 싶다면 10으로 변경)
			if(currentP == null)
				recordId = 1;
			else
				recordId = (Integer.parseInt(currentP) - 1)*5 + 1;
		%>
		<div style="text-align: center">
			<form>
				<table id="recordT" style="table-layout: auto; table-layout: fixed;">

					<tr>
						<td align="center" bgcolor="E6ECDE" height="50" class="a"
							style="border-top: 1px solid black;">글 번호</td>
						<td align="center" bgcolor="E6ECDE" class="a"
							style="border-top: 1px solid black;">제목</td>
						<td align="center" bgcolor="E6ECDE" class="a"
							style="border-top: 1px solid black;">분류</td>
						<td align="center" bgcolor="E6ECDE" class="a"
							style="border-top: 1px solid black;">작성자</td>
					</tr>
					<c:forEach var="record" items="${recordList}">
						<tr>
							<td align="center" bgcolor="ffffff" height="35" class="a">
								<%= recordId++ %></td>
							<td bgcolor="ffffff" style="padding-left: 10" class="b"><a
								href="<c:url value='/myRecord/list/detail'><c:param name='recordId' value='${record.recordId}'/></c:url>">${record.title}</a>
							</td>
							<td bgcolor="ffffff" style="padding-left: 10" align="center"
								class="a"><c:if test="${record.category eq '1'}">
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
							<td bgcolor="ffffff" style="padding-left: 10" align="center"
								class="b">${nickname}</td>
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
				<a href="<c:url value='/myRecord/list'><c:param name='currentPage' value='<%= str %>'/></c:url>"><%= j %></a>
				<%
				}
				%>
		</div>
		
		<!-- 글작성 -->
		<form action="<c:url value='/myRecord/write' />" method="GET">
			<button type="submit" class="record_btn">기록 작성하기</button>
		</form>

	</div>
</div>

<%@ include file="../frameFooter.jsp"%>