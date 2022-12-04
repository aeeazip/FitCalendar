package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.ExerciserSessionUtils;
import model.Exerciser;
import model.service.ExerciserManager;
import model.service.MatchingManager;

//MatMate 값 변경
public class UpdateOptionController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateOptionController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MatchingManager manager = MatchingManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("id");

		// 로그인한 사용자의 exerciser 객체
		Exerciser exerciser = exManager.findExerciser(userId);

		try {
			String maxMate = request.getParameter("maxMate");
			int max = Integer.parseInt(maxMate);
			manager.optionChange(exerciser.getExerciserId(), max, "T");
			return "redirect:/matching/matchingMenu"; // 성공 시, 해당 페이지로 forwarding
		} catch (Exception e) {
			request.setAttribute("checkFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciserId", exerciser.getExerciserId());

		}

		return "redirect:/matching/option/setMate"; // 실패 시, 다시 maxMate설정 페이지로!(안넘어가게)
	}
}
