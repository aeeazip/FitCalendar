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
import model.RecommendList;
import model.service.ExerciserManager;
import model.service.RecommendManager;


public class MatchingGetRecommendListController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingGetRecommendListController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RecommendManager recommManager = RecommendManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();
		
		HttpSession session = request.getSession();
		
		//로그인한 사용자의 exerciser 객체
		Exerciser exerciser = exManager.findExerciser(ExerciserSessionUtils.getLoginUserId(session));

		List<RecommendList> recommendList = recommManager.showGetRecommendList(exerciser.getExerciserId());

		//recommendList 전달해서 forwarding
		request.setAttribute("recommendList", recommendList);
		
	
		return "/matching/matchingMenu/getRecommendList.jsp";
	}

}
