package controller.exerciser;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogoutController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// hasLogined 확인
		if (UserSessionUtils.hasLogined(request.getSession())) {
			System.out.println("hasLogined 확인  !!");
		}

		// 세션에 저장된 사용자 이이디를 삭제하고 세션을 무효화 함
		HttpSession session = request.getSession();
		System.out.println("14행 : " + session.getAttribute("id"));
		session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
		session.invalidate();

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('로그아웃 되었습니다.'); location.href='../main'; </script>");

		System.out.println("로그아웃");
		out.flush();

		return "/main.jsp";
	}
}
