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
import model.service.RecommendManager;

public class MatchingWantRecommendController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(MatchingWantRecommendController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RecommendManager recommendManager = RecommendManager.getInstance();
		ExerciserManager exerciserManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession(); 

		String id = (String) session.getAttribute("id");

		System.out.println("matchingWantRecommendController");
		Exerciser exerciser = exerciserManager.findExerciser(id);

		int result = recommendManager.recommendExerciser(exerciser.getExerciserId());
		System.out.println(result);
		try {
			if(result != 0)
				return "redirect:/matching/wantRecommend/list";
		}catch(Exception e){
			request.setAttribute("MatchingFailed", true);
			request.setAttribute("exerciser", exerciser);
		}

		return "redirect:/matching/wantRecommend";
	}	

}
