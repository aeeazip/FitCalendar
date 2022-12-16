package controller.matching;

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

public class MatchingWantListController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingWantListController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RecommendManager recommendManager = RecommendManager.getInstance();
		ExerciserManager exerciserManager = ExerciserManager.getInstance();
		RecommendList recommendList;

		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		Exerciser exerciser = exerciserManager.findExerciser(id);
	
		recommendList = recommendManager.displayExerciser(exerciser.getExerciserId());
		Exerciser recomm1 = exerciserManager.findExerciserById(recommendList.getRecommend1());
		Exerciser recomm2 = exerciserManager.findExerciserById(recommendList.getRecommend2());
		Exerciser recomm3 = exerciserManager.findExerciserById(recommendList.getRecommend3());
		try {
		if(recommendList != null) {
			if(recommendList.getCounting() == 0) {
				request.setAttribute("recomm", recomm1);
				request.setAttribute("recommId", recomm1.getId());
			}else if(recommendList.getCounting() == 1) {
				request.setAttribute("recomm", recomm2);
				request.setAttribute("recommId", recomm2.getId());
			}else if(recommendList.getCounting() ==2){
				request.setAttribute("recomm", recomm3);
				request.setAttribute("recommId", recomm3.getId());
			}else {
				if(recommendList.getCounting() > 3)
					recommendManager.countZero(exerciser.getExerciserId());
				return "redirect:/matching/matchingMenu";
			}
		}
		return "/matching/wantRecommendList.jsp";
		}catch(Exception e) {
			 request.setAttribute("MatchingWantListFailed", true);
	         request.setAttribute("exerciser", exerciser);
		}

		return "redirect:/exerciser/main";
	}
}
