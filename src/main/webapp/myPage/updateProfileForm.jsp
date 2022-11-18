<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>updateProfileForm</title>
<link rel="stylesheet" href="updateProfileForm.css">
</head>
<body>
	<form name="updateProfileForm" method="POST"
		action="<c:url value='/mypage/profile/update' />">
		<!-- 2. 필드 -->
		<div class="field">
			<b>아이디</b> <span class="placehold-text"><input type="text"
				value="${exerciser.id}"></span>
		</div>
		<div class="field">
			<b>비밀번호</b> <input class="userpw" type="password"
				value="${exerciser.password}">
		</div>
		<div class="field">
			<b>비밀번호 재확인</b> <input class="userpw-confirm" type="password">
		</div>
		<div class="field">
			<b>닉네임</b> <input type="text" value="${exerciser.nickname}">
		</div>

		<div class="field">
			<b>한줄 소개</b> <input type="text" value="${exerciser.explanation}">
		</div>

		<div class="field">
			<b>운동 주종목</b> <input type="text" value="${exerciser.speciality}">
		</div>

		<div class="field">
			<b>성격</b> <input type="text" value="${exerciser.personality}">
		</div>

		<div class="field gender">
			<b>성별</b>
			<div>
				<label><input type="radio" name="gender">남자</label> <label><input
					type="radio" name="gender">여자</label>
			</div>
		</div>

		<div class="field gender">
			<b>Do you want to use Matching Service?</b>
			<div>
				<label><input type="radio" name="userMatchSvc">Yes</label> <label><input
					type="radio" name="useMatchSvc">No</label>
			</div>
		</div>
		<!-- 6. 가입하기 버튼 -->
		<input type="submit" value="가입하기">
	</form>
</body>
</html>