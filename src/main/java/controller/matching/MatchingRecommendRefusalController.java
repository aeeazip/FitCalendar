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

public class MatchingRecommendRefusalController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingRecommendRefusalController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MatchingManager matchingManager = MatchingManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		// 로그인한 사용자의 exerciser 객체
		Exerciser exerciser = exManager.findExerciser(id);

		String fitMateId = (String)request.getParameter("fitmateId");
		Exerciser fitmate = exManager.findExerciser(fitMateId);

		// matchingStatus 바꿔주기
		matchingManager.matchingRefuse(exerciser.getExerciserId(), fitmate.getExerciserId());

		//다시 나를 fitmate 신청한 페이지로 돌아가기
		return "redirect:/matching/getRecommendList";
	}

}
