package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class UpdateProfileController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateProfileController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");

		if (request.getMethod().equals("GET")) {
			// GET request: 커뮤니티 수정 form 요청

			return "/myPage/updateProfileForm.jsp";
		}
		// POST request (커뮤니티 정보가 parameter로 전송됨)

		return "redirect:/myPage/profile/update";
	}

}
