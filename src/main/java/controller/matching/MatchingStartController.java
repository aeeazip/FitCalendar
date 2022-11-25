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

//Matching 시작버튼 누름 -> useMatchSvc 버튼 값 변경 
public class MatchingStartController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingStartController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MatchingManager matchingManager = MatchingManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();

		// 로그인한 사용자의 exerciser 객체
		Exerciser exerciser = exManager.findExerciser(ExerciserSessionUtils.getLoginUserId(session));

		// useMatchSvc값 변경
		try {
			if (ExerciserSessionUtils.getLoginUserId(session).equals(exerciser.getExerciserId())) {
				exerciser.setUseMatchSvc("T");
				int result = matchingManager.createOption(exerciser.getExerciserId(), exerciser.getUseMatchSvc());
				// createOption 성공
				if (result == 1)
					return "/matching/setMaxMate.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("CreateOptionsFailed", true);
			request.setAttribute("exerciser", exerciser);
		}
		// 실패시, 다시 설정하도록 같은 페이지
		return "redirect:matching/startMatching";
	}
}