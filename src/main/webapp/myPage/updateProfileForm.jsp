<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>updateProfileForm</title>
<link rel="stylesheet" href="updateProfileForm.css">
</head>
<body>
	<div class="flex-container">
		<div id="wrapper">
			<!-- header -->
			<div class="header">

				<!-- 로그인, 회원가입 -->
				<div id="userMenu">
					<ul class="list_menu">
						<li class="menu menu_login"><a class="link link_login"
							href="../html/login.html">로그인</a></li>
						<li class="menu menu_join"><a class="link link_join" href="#">회원가입</a>
						</li>
					</ul>
				</div>

				<!-- 로고 -->
				<div id="headerLogo" class="layout-wrapper">
					<h1 class="logo">
						<a class="link_main" href="../html/main.html">
							<p class="logo">Fit Calendar</p>
						</a>
					</h1>
				</div>

				<!-- 메뉴바 -->
				<div class="gnb_main">
					<ul class="gnb">
						<li class="menu1"><a href="" class="link all">나의 기록</a>
						<li class="menu2"><a href="#" class="link new">운동 기록</a></li>
						<li class="menu3"><a href="#" class="link best">Fit Mate</a>
						</li>
						<li class="menu4"><a href="#" class="link bargain">추천/매칭</a>
						</li>
						<li class="menu5"><a href="#" class="link event">마이페이지</a></li>
					</ul>
				</div>

			</div>
			<!-- container -->
			<div class="container">
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
			</div>

		</div>

		<!-- footer -->
		<footer>
			<div class="container">
				<table>
					<div class="row justify-content-center">
						<div class="col-sm-4 col-md-3 item">
							<td>
								<p id="fit_footer">Fit Calendar</p> <a href="#">개인정보처리방침</a>&nbsp;<a
								href="#">이용약관</a>&nbsp;<a href="#">제휴문의</a>
								<p id="from">동덕여대&nbsp;&nbsp;데이터베이스프로그래밍</p>
							</td>
						</div>
						<div class="col-sm-4 col-md-3 item">
							<td>
								<ul>
									<p id="info">
										서비스명: Fit Calendar / 양혜지 오인우 정채원 한호정 / 8색조 <br>개인정보 보호
										책임자: 한호정 / Email: hojeong2747@gmail.com
									</p>
									<p>COPYRIGHT (C) ALL RIGHTS RESERVED</p>
								</ul>
							</td>
						</div>
					</div>
				</table>
			</div>
		</footer>
	</div>
</body>
</html>