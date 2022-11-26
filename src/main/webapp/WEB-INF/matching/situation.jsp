<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RecommendList</title>
<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/css/situation.css' />" type="text/css">
</head>
<%@ include file="../frameHeader.jsp" %>
<body>
<div align ="center">
<h3>FitMate 요청 상태</h3>

<c:if test="${matchingStatus}.size() == 0 }">
	<tfoot>
		<tr>
			<td colspan="3">현재 요청하신 FitMate가 존재하지 않습니다..</td>
		</tr>
	</tfoot>
</c:if>
<tbody>
	<c:forEach var="result" items="${matchingStatus}" varStatus="status">
		<tr>
			<td><c:out value="${result.reciever }"/></td>
			<td><c:out value="${result.status }"/></td>
		</tr>
	</c:forEach>
</tbody>
</table>

<%@ include file="../frameFooter.jsp" %>
</html>