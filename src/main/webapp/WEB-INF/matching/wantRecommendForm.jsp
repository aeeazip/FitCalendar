<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>wantRecommendForm</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/wantRecommendForm.css' />" type="text/css">
	<link rel="stylesheet" href="<c:url value='/css/startMatching.css' />" type="text/css">
	<script>

		function recommend(targetUri) {
			form.action = targetUri;
			form.submit();
		}
	</script>
</head>


<%@ include file="../frameHeader.jsp"%>

<div id="main">
	
		<div class="flex-container2">
			<div id="subTitle" >
				<p class="subTitle" style="font-size:18px; margin-bottom:30px;">원하는 FitMate 정보를 체크하세요.</p>
			</div>
			<div style="text-align: center">
				<form name="form" method="POST" action="<c:url value='/matching/wantRecommend/form' />">
					<table style="table-layout: auto; table-layout: fixed;">
						<tr>
							<td class="a" style="border-top: 1px solid black;"><b>성별</b></td>
							<td class="b" style="border-top: 1px solid black;"><input
								type="radio" name="gender" value="male" checked>남자 <input
								type="radio" name="gender" value="female">여자</td>
						</tr>
						<tr>
							<td class="a"><b>키</b></td>
							<td class="b">
								<table style="table-layout: auto; table-layout: fixed;">
									<tr>
										<td><input type="radio" name="height" value="1" checked>~
											160cm</td>
										<td><input type="radio" name="height" value="2">160
											~ 169cm</td>
									</tr>
									<tr>
										<td><input type="radio" name="height" value="3">170
											~ 179cm</td>
										<td><input type="radio" name="height" value="4">180cm
											~</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td class="a"><b>몸무게</b></td>
							<td class="b">
								<table>
									<tr>
										<td><input type="radio" name="weight" value="1" checked>~
											50kg</td>
										<td><input type="radio" name="weight" value="2">50
											~ 59kg</td>
									</tr>
									<tr>
										<td><input type="radio" name="weight" value="3">60
											~ 69kg</td>
										<td><input type="radio" name="weight" value="4">70
											~ 79kg</td>
									</tr>
									<tr>
										<td><input type="radio" name="weight" value="5">80
											~ 89kg</td>
										<td><input type="radio" name="weight" value="6">90kg
											~</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td class="a"><b>체지방률</b></td>
							<td class="b">
								<table>
									<tr>
										<td><input type="radio" name="percentBodyFat" value="1">0
											~ 15%</td>
										<td><input type="radio" name="percentBodyFat" value="2"
											checked>15 ~ 25%</td>
										<td><input type="radio" name="percentBodyFat" value="3">25
											~ 35%</td>
										<td><input type="radio" name="percentBodyFat" value="4">35%
											~</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td class="a"><b>원하는 운동 종목</b></td>
							<td class="b">
								<table>
									<tr>
										<td><input type="radio" name="category" value="1" checked>헬스</td>
										<td><input type="radio" name="category" value="2">요가/필라테스</td>
										<td><input type="radio" name="category" value="3">러닝</td>
										<td><input type="radio" name="category" value="4">기타</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan='2'><button type="submit" class="start_btn" style="margin-top:30px">매칭 시작하기</button></td>
						</tr>
					</table>
				</form>
			<form name="startMateForm"
				action="<c:url value='/matching/matchingMenu' />" method="GET">
				<button type="submit" class="start_btn" >menu 화면으로 돌아가기</button>
			</form>
			</div>
			
		</div>
	
</div>


<%@ include file="../frameFooter.jsp"%>