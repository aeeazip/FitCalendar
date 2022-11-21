<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>wantRecommendForm</title>
    <link rel="stylesheet" href="../../frame.css">
    <link rel="stylesheet" href="wantRecommendForm.css">
</head>


<%@ include file="../../frameHeader.jsp" %>

<div id="main">
	<form>
		<div class="flex-container2">
			<div id="subTitle">
				<p class="subTitle">원하는 FitMate 정보를 입력하시오</p>
			</div>
				
				<div style="text-align:center">
					<form action="matchingResult_third.html">
						<table style = "table-layout: auto; table-layout: fixed;">
							<tr>
								<td class="a" style="border-top: 1px solid black;"><b>성별</b></td>
								<td class="b" style="border-top: 1px solid black;">
									<input type="radio" name="gender" value="male" checked>남자
									<input type="radio" name="gender" value="female">여자
								</td>
							</tr>
							<tr>
								<td class="a"><b>키</b></td>
								<td class="b">
									<table style = "table-layout: auto; table-layout: fixed;">
										<tr>
											<td><input type="radio" name="height" value="1" checked>~ 160cm</td>
											<td><input type="radio" name="height" value="2">160 ~ 169cm</td>
										</tr>
										<tr>
											<td><input type="radio" name="height" value="3">170 ~ 179cm</td>
											<td><input type="radio" name="height" value="4">180cm ~ </td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td class="a"><b>몸무게</b></td>
								<td class="b">
									<table>
										<tr>
											<td><input type="radio" name="weight" value="1" checked>~ 50kg</td>
											<td><input type="radio" name="weight" value="3">50 ~ 59kg</td>
										</tr>
										<tr>
											<td><input type="radio" name="weight" value="5">60 ~ 69kg</td>
											<td><input type="radio" name="weight" value="7">70 ~ 79kg</td>
										</tr>
										<tr>
											<td><input type="radio" name="weight" value="9">80 ~ 89kg</td>
											<td><input type="radio" name="weight" value="11">90kg ~ </td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td class="a"><b>체지방률</b></td>
								<td class="b">
									<table>
										<tr>
											<td><input type="radio" name="percentBodyFat" value="1">0 ~ 15%</td>
											<td><input type="radio" name="percentBodyFat" value="2" checked>15 ~ 25%</td>
											<td><input type="radio" name="percentBodyFat" value="3">25 ~ 35%</td>
											<td><input type="radio" name="percentBodyFat" value="4">35% ~ </td>
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
								<td colspan='2'><input text-align = "center" type="submit" id="submit_btn" value="입력 정보 전송"></td>
							</tr>
						</table>	
					</form>
				</div>
				</div></form></div>


<%@ include file="../../frameFooter.jsp" %>