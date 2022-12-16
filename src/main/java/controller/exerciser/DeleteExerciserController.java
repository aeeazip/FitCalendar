package controller.exerciser;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.service.ExerciserManager;

public class DeleteExerciserController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DeleteExerciserController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String deletePwd = request.getParameter("exerciserPwd");

		ExerciserManager manager = ExerciserManager.getInstance();
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");

		Exerciser deleteExerciser = manager.findExerciser(id);

		if (request.getServletPath().equals("/mypage/delete/form")) {
			return "/myPage/deleteForm.jsp";
		} else if (request.getServletPath().equals("/mypage/delete")) {
			int result = manager.deleteExerciser(deleteExerciser.getExerciserId(), deletePwd); // 사용자 정보 삭제
			System.out.println("deleteResult: " + result);
			if (result != 0) {
				session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
				session.invalidate();
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('탈퇴 되었습니다.'); location.href='../main'; </script>");

				out.flush();

				return "/main.jsp";
			}
			return "redirect:/mypage/delete/form";
		}

		return "redirect:/mypage/delete/form";
	}
}