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
import model.Fitmate;
import model.RecommendList;
import model.service.ExerciserManager;
import model.service.MatchingManager;


public class MatchingCompleteController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingGetRecommendListController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MatchingManager matchingManager = MatchingManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();
			
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("id");
		System.out.println("controllerComplete");
	    // 로그인한 사용자의 exerciser 객체
	    Exerciser exerciser = exManager.findExerciser(userId);
	      
	    String fitmateid = request.getParameter("fitmateId");
	    System.out.println(fitmateid);
		//상대exerciser(=fitmate) ID
	    Exerciser fitmate = exManager.findExerciser(fitmateid);
		
		//accept -> fitmate table에 저장
		matchingManager.acceptRecommend(exerciser.getExerciserId(), fitmate.getExerciserId());
		
		//매칭 수락시, status=1로 바꿔주기		
		matchingManager.matchingComplete(exerciser.getExerciserId(), fitmate.getExerciserId());
		
		//매칭 수락 시, fitmate list 보여주는 페이지로 이동
		List<Fitmate> fitmateList =  matchingManager.showFitmateList(exerciser.getExerciserId());
		
		request.setAttribute("fitmateList", fitmateList);
		
		return "redirect:/matching/fitmate";
	}

}
