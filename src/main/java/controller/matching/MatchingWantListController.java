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
		//if(recommendManager.recommendExerciser(exerciser.getExerciserId()) != 0)
			
		//recommendList = recommendManager.displayExerciser(exerciser.getExerciserId());
		//recommendList = recommendManager.displayExerciser(1);
		//추천 기록이 있다면 추천 실행 아니라면 추천 실행 ㄴ
		recommendList = recommendManager.displayExerciser(21);
	
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
