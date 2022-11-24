package controller.exerciser;

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
		String deleteId = request.getParameter("exerciserId");
		String deletePwd = request.getParameter("exerciserPwd");
		log.debug("Delete User : {}", deleteId);

		ExerciserManager manager = ExerciserManager.getInstance();
		HttpSession session = request.getSession();

		if ((ExerciserSessionUtils.isLoginUser("admin", session) && // 로그인한 사용자가 관리자이고
				!deleteId.equals("admin")) // 삭제 대상이 일반 사용자인 경우,
				|| // 또는
				(!ExerciserSessionUtils.isLoginUser("admin", session) && // 로그인한 사용자가 관리자가 아니고
						ExerciserSessionUtils.isLoginUser(deleteId, session))) { // 로그인한 사용자가 삭제 대상인 경우 (자기 자신을 삭제)

			int result = manager.deleteExerciser(deleteId, deletePwd); // 사용자 정보 삭제

			if (result == 1)
				return "redirect:/main"; // logout 처리
		}

		/* 삭제가 불가능한 경우 */
		Exerciser exerciser = manager.findExerciser(deleteId); // 사용자 정보 검색
		request.setAttribute("exerciser", exerciser);
		request.setAttribute("deleteFailed", true);
		String msg = (ExerciserSessionUtils.isLoginUser("admin", session)) ? "시스템 관리자 정보는 삭제할 수 없습니다."
				: "타인의 정보는 삭제할 수 없습니다.";
		request.setAttribute("exception", new IllegalStateException(msg));
		return "/exerciser/deleteForm.jsp"; // 삭제 폼 다시 작성 (forwarding)
	}

}