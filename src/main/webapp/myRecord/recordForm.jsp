<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>recordForm</title>
<link href="recordForm.css" rel="stylesheet" type="text/css">
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
			<!-- recordForm 부분 -->
			<div class="container">
				<form name="form" method="POST" action="<c:url value='/myRecord/write'/>">
					<div class="recordForm">
						<h1 style="font-size: 21px;">_________님의 운동 일지</h1>
					</div>
					<div class="name">
						<input type="text" name="title" placeholder="제목을 입력해 주세요.">
					</div>
					<div class="name">
						<input type="date" name="creationdate">
					</div>
					<div class="name">
						<input type="text" name="totaltime"
							placeholder="총 운동시간을 입력해 주세요. (예: 3)">
					</div>
					<div class="line">
						<hr>
					</div>
					<div class="area">
						<select id="category" name="category">
							<option selected>종목을 선택하세요.</option>
							<option>헬스</option>
							<option>필라테스</option>
							<option>요가</option>
							<option>러닝</option>
							<option>기타</option>
						</select>
					</div>
					<div class="name">
						<textarea rows="5" cols="115" name="routine"
							aria-label="With textarea" placeholder="운동 루틴을 입력하세요."></textarea>
					</div>
					<div class="name">
						<textarea rows="5" cols="115" name="diet"
							aria-label="With textarea" placeholder="식단을 입력하세요."></textarea>
					</div>
					<div class="name">
						<input type="file" name="photo">
					</div>
					<div class="name">
						<select name="shareOption">
							<option selected>기록 공유를 하시겠습니까?</option>
							<option>예</option>
							<option>아니오</option>
						</select>
					</div>
					<div class="button">
						<button type="button" onclick="signUpCheck()">등록하기</button>
					</div>
				</form>
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