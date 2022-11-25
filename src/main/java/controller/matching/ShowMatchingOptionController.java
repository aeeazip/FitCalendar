
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


public class ShowMatchingOptionController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(MatchingStartController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MatchingManager manager = MatchingManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();
		
		//로그인한 사용자의 exerciser 객체
		Exerciser exerciser = exManager.findExerciser(ExerciserSessionUtils.getLoginUserId(session));
		
		//maxMate 설정하기
		int maxMate = Integer.getInteger(request.getParameter("maxMate"));
		try {
			manager.optionChange(exerciser.getExerciserId(), maxMate, exerciser.getUseMatchSvc());
			return "/matching/matchingMenu.jsp"; //성공 시, 해당 페이지로 forwarding
		} catch (Exception e) {
			request.setAttribute("checkFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciserId", exerciser.getExerciserId());
			return "/matching/setMaxMate.jsp"; //실패 시, 다시 maxMate설정 페이지로!
		}
	}
}