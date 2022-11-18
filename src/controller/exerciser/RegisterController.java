package controller.exerciser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import main.java.Dto.Exerciser;

public class RegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getMethod().equals("GET")) {
			// GET request: 회원정보 등록 form 요청
			return "/exerciser/registerForm.jsp";
		}

		// POST request (회원정보가 parameter로 전송됨)
		Exerciser exerciser = new Exerciser(request.getParameter("id"), request.getParameter("password"),
				request.getParameter("nickname"), request.getParameter("explanation"),
				request.getParameter("speciality"), request.getParameter("personality"),
				request.getParameter("gender"));

		return null;
	}

}
