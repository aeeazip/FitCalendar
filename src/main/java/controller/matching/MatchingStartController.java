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

		String userId = (String) session.getAttribute("id");
		// 로그인 했는지 체크하고, 안했으면 login으로!
		if (userId == null) {
			return "redirect:/exerciser/login";
		}
		// 로그인한 사용자의 exerciser 객체
		Exerciser exerciser = exManager.findExerciser(userId);
		
		//이미 useMatchSvc 값이 true면 그냥 바로 메뉴로!
		if(exerciser.getUseMatchSvc().equals("T")) {
			return "redirect:/matching/matchingMenu";
		}
		
		// useMatchSvc값 변경
		try {
			if (userId.equals(exerciser.getId())) {
				
				exerciser.setUseMatchSvc("T");
				matchingManager.createOption(exerciser.getExerciserId(), exerciser.getUseMatchSvc());
				// createOption 성공

				request.setAttribute("nickname", exerciser.getNickname());
				return "/matching/startMatching.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("CreateOptionsFailed", true);
			request.setAttribute("exerciser", exerciser);
		}
		// 모든 것이 실패시, main으로
		return "redirect:/exerciser/main";
	}

}