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
public class UpdateAllOptionController implements Controller {
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

		int maxMate = Integer.getInteger(request.getParameter("maxMate"));

		// option(매칭 설정 취소 or maxMate 재설정) 전체 설정
		String useMatchSvc = request.getParameter("useMatchSvc");
		try {
			manager.optionChange(exerciser.getExerciserId(), maxMate, useMatchSvc);
			return "/matching/setOptions.jsp"; 
		} catch (Exception e) {
			return "redirect:/matching/matchingMenu"; 
		}
	}
}
