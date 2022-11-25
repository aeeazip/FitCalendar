package controller.matching;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.ExerciserSessionUtils;
import model.Exerciser;
import model.MatchingStatus;
import model.service.ExerciserManager;
import model.service.MatchingManager;

public class MatchingSituationController  implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingSituationController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MatchingManager matchingManager = MatchingManager.getInstance();
		ExerciserManager exerciserManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();
		Exerciser exerciser = exerciserManager.findExerciser(ExerciserSessionUtils.getLoginUserId(session));

		List<MatchingStatus> matchingStatus = matchingManager.showSitationList(exerciser.getExerciserId());

		//MatchingStatusList를 보내고 jsp 에서 반복문으로 찍어냄(setAttribute 변수 이름을 계속 다르게 줘야하기 때문)
		request.setAttribute("matchingStatus", matchingStatus);
	
		return "/matching/matchingMenu/situation.jsp";
	}

}
