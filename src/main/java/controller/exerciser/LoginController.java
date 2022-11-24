package controller.exerciser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class LoginController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {
			// GET request: 회원정보 등록 form 요청
			log.debug("LoginForm Request");
			return "/exerciser/loginForm.jsp";
		}
		return "/main.jsp";
	}

}
