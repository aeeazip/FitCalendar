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

		Exerciser exerciser = exerciserManager.findExerciser(ExerciserSessionUtils.getLoginUserId(session));

		recommendList = recommendManager.displayExerciser(exerciser.getExerciserId());

		//추천한 사용자에 대해선 재 추천시, null로 만들어야함
		if(recommendList != null) {
			if(recommendList.getCounting() == 0) {
				request.setAttribute("recommName", recommendList.getRecommend1().getNickname());
				request.setAttribute("recommExplanation", recommendList.getRecommend1().getExplanation());
				request.setAttribute("recommSpeciality", recommendList.getRecommend1().getSpeciality());
				request.setAttribute("recommPersonality", recommendList.getRecommend1().getPersonality());
				request.setAttribute("recommGender", recommendList.getRecommend1().getGender());
			}else if(recommendList.getCounting() == 1) {
				request.setAttribute("recommName", recommendList.getRecommend2().getNickname());
				request.setAttribute("recommExplanation", recommendList.getRecommend2().getExplanation());
				request.setAttribute("recommSpeciality", recommendList.getRecommend2().getSpeciality());
				request.setAttribute("recommPersonality", recommendList.getRecommend2().getPersonality());
				request.setAttribute("recommGender", recommendList.getRecommend2().getGender());
			}else if(recommendList.getCounting() ==2){
				request.setAttribute("recommName", recommendList.getRecommend3().getNickname());
				request.setAttribute("recommExplanation", recommendList.getRecommend3().getExplanation());
				request.setAttribute("recommSpeciality", recommendList.getRecommend3().getSpeciality());
				request.setAttribute("recommPersonality", recommendList.getRecommend3().getPersonality());
				request.setAttribute("recommGender", recommendList.getRecommend3().getGender());
			}else {
				request.setAttribute("EndRecommend", "The number of recommendations allowed has been exceeded.");
			}
		}


		return "redirect:/matching/matchingMenu/wantRecommend/list";
	}
}
