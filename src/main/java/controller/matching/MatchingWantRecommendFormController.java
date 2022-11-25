package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.RecommendList;
import model.service.RecommendManager;

public class MatchingWantRecommendFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RecommendManager recommendManager = RecommendManager.getInstance();
		
		int exerciserId = Integer.parseInt(request.getParameter("exerciserId"));
		
		if(recommendManager.recommendExerciser(exerciserId) != 0)
			return "/matching/matchingMenu/wantRecommendList.jsp";
		
		return "/matching/matchingMenu/wantRecommedForm.jsp";
	}
}
