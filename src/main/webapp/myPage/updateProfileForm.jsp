<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>updateProfileForm</title>
	<link rel="stylesheet" href="updateProfileForm.css">
	<link rel="stylesheet" href="../frame.css">
</head>

<%@ include file="../frameHeader.jsp" %>

				<div id="main">
					<form>
						<div class="flex-container2">
							<div id="subTitle">
								<p class="subTitle">____님 정보 수정</p>
							</div>
							<div id="loginBox">
								<div class="box">
									<input type="text" class="inputId" id="id" maxlength="30"
										name="id" placeholder="아이디" onfocus="this.placeholder = ''"
										onblur="this.placeholder = '아이디'">
									<p class="alert validId1"></p>
								</div>
								<div class="box">
									<input type="password" class="inputPW" id="pswd1"
										maxlength="30" name="password" placeholder="비밀번호"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = '비밀번호'">
									<p class="alert validpwd2"></p>
								</div>
								<div class="box">
									<input type="text" class="inputPW" maxlength="30"
										name="nickname" placeholder="닉네임"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = '닉네임'">
								</div>
								<div class="box">
									<input type="text" class="inputPW" maxlength="30"
										name="explanation" placeholder="한줄소개"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = '한줄소개'">
								</div>
								<div class="box">
									<input type="text" class="inputPW" maxlength="30"
										name="personality" placeholder="성격"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = '성격'">
								</div>

								<div class="box">
									<p>Do you want to use Matching Service?</p>
									<input type="radio" id="t" name="t" value="1" checked> 
									yes<br>
									<input type="radio" id="f" name="f" value="0"> 
									no<br>
								</div>

							</div>
							<div>
								<button type="button" id="update_btn" onclick="update_check();">정보
									수정</button>
							</div>
						</div>
					</form>
				</div>
				
				
<%@ include file="../frameFooter.jsp" %>