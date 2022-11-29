package controller.matching;

import java.util.ArrayList;
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
		System.out.println("완료");
		
		//매칭 수락시, status=1로 바꿔주기		
		matchingManager.matchingComplete(exerciser.getExerciserId(), fitmate.getExerciserId());
		
		// 매칭 수락 시 시스템에서 fitmate간 메시지 활성화
		int result = matchingManager.notifyMatching(fitmate.getExerciserId(), exerciser.getExerciserId()); // 나
		System.out.println(result);
		
		int result1 = matchingManager.notifyMatching(exerciser.getExerciserId(), fitmate.getExerciserId()); //상대
		System.out.println(result1);
		
		//매칭 수락 시, fitmate list 보여주는 페이지로 이동
		List<Fitmate> fitmateList =  matchingManager.showFitmateList(exerciser.getExerciserId());
		List<Exerciser> fitmate_list = new ArrayList<Exerciser>();
		Exerciser fitmate_item;
		
		for(Fitmate item: fitmateList) {
			if(item.getExerciser1() == exerciser.getExerciserId()) {
				fitmate_item = exManager.findExerciserById(item.getExerciser2());
				System.out.println("exerciser1 fitmate");
			}
			else {
				fitmate_item = exManager.findExerciserById(item.getExerciser1());
				System.out.println("exerciser2 fitmate");
			}
			
			fitmate_list.add(fitmate_item);
				
		}
		
		for(Exerciser exer : fitmate_list) {
			System.out.println(exer.getNickname());
		}
		
		request.setAttribute("fitmateList", fitmate_list);
		
		return "redirect:/matching/fitmate";
	}

}
