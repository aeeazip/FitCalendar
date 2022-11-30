package controller.exerciser;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.ExerciserManager;

public class LoginController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {
			// GET request: 회원정보 등록 form 요청
			log.debug("LoginForm Request");
			return "/exerciser/loginForm.jsp";
		}

		// POST request (회원정보가 parameter로 전송됨)
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		try {
			ExerciserManager.getInstance().login(id, pwd);

			HttpSession session = request.getSession(true);
			System.out.println(session.getAttribute("id"));
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, id);
			System.out.println(
					"36행 : " + UserSessionUtils.USER_SESSION_KEY + "\n" + UserSessionUtils.getLoginUserId(session));

			// alert창
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 되었습니다.'); location.href='../main'; </script>");

			out.flush();

			return "redirect:/main";
		} catch (Exception e) {
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			return "/exerciser/loginForm.jsp";
		}
	}

}
