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

		//HttpSession session = request.getSession();

		//Exerciser exerciser = exerciserManager.findExerciser(ExerciserSessionUtils.getLoginUserId(session));

		//recommendList = recommendManager.displayExerciser(exerciser.getExerciserId());
		recommendList = recommendManager.displayExerciser(1);
		//추천한 사용자에 대해선 재 추천시, null로 만들어야함
		if(recommendList != null) {
			if(recommendList.getCounting() == 0) {
				request.setAttribute("recomm", recommendList.getRecommend1());
			}else if(recommendList.getCounting() == 1) {
				request.setAttribute("recomm", recommendList.getRecommend2());
			}else if(recommendList.getCounting() ==2){
				request.setAttribute("recomm", recommendList.getRecommend3());
			}else {
				request.setAttribute("EndRecommend", "The number of recommendations allowed has been exceeded.");
			}
		}


		return "/matching/wantRecommendList.jsp";
	}
}
