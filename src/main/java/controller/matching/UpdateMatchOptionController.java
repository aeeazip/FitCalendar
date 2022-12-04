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

//UseMatchSvc 옵션 끄기(매칭 서비스 불가)
public class UpdateMatchOptionController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingStartController.class);

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
			exerciser.setUseMatchSvc("F");
			request.setAttribute("nickname", exerciser.getNickname());
			manager.optionChange(exerciser.getExerciserId(), 0, exerciser.getUseMatchSvc());
			return "redirect:/main"; // 성공 시, main 페이지로 forwarding
			
		} catch (Exception e) {
			request.setAttribute("checkFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciserId", exerciser.getExerciserId());
		}

		return "redirect:/matching/option/setOption"; // 실패 시, 다시 maxMate설정 페이지로!(안넘어가게)

	}
}
