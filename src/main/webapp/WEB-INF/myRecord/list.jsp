<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>recordForm</title>
	<link rel="stylesheet" href="<c:url value='/css/frame.css' />" type="text/css">
</head>
<body>
	<%
		int cnt = Integer.parseInt((String)request.getAttribute("cnt"));	// 내가 작성한 총 Record 개수 확인
		int pageSize = 3;		// 한 페이지에 출력될 글 수 
		
		String pageNum = request.getParameter("pageNum");		// 현 페이지 정보 설정
		if(pageNum == null){
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);		
		int startRow = (currentPage - 1) * pageSize + 1;		// 첫행번호를 계산
		
		
		// https://heezit.tistory.com/84?category=965695
		// 이거 보고 마저 작성합시다잉
	%>
</body>
</html>