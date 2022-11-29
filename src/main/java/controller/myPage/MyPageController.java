package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class MyPageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("id");
		// 로그인 했는지 체크하고, 안했으면 login으로.
		if (userId == null) {
			return "redirect:/exerciser/login";
		}

		return "/myPage/myPageMenu.jsp";
	}

}
