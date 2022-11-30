package controller.exerciser;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.service.ExerciserManager;
import model.service.MatchingManager;

public class ShowExerciserInfoController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ExerciserManager manager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();
	      
	    String userId = (String)session.getAttribute("id");
	    
	    if(userId == null) {
	    	return "redirect:/";
	    }
	    
	    // 로그인한 사용자의 exerciser 객체
	    Exerciser exerciser = manager.findExerciser(userId);
	    
	    manager.showInfo(exerciser.getExerciserId(), exerciser.getNickname(), exerciser.getPoint(), exerciser.getExplanation(), exerciser.getGender());
	    
	    request.setAttribute("nickname", exerciser.getNickname());
	    request.setAttribute("point", exerciser.getPoint());
	    request.setAttribute("explanation", exerciser.getExplanation());
	    request.setAttribute("gender", exerciser.getGender());
	    request.setAttribute("exerciser", exerciser);
	    
	    
	    
	    //랭킹관련
	    List<Exerciser> eList = manager.showRanking();
	    
	    request.setAttribute("rankingList", eList);
	         
		return "/main.jsp";
	}

}
