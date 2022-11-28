
package controller.matching;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.Fitmate;
import model.service.ExerciserManager;
import model.service.MatchingManager;


public class ShowFitmateController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(MatchingStartController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MatchingManager manager = MatchingManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();
	      
	    String userId = (String)session.getAttribute("id");
	    
	    // 로그인한 사용자의 exerciser 객체
	    Exerciser exerciser = exManager.findExerciser(userId);
	      
		List<Fitmate> fitmateList = manager.showFitmateList(exerciser.getExerciserId());
		
		request.setAttribute("fitmateList", fitmateList);
		
		return "/matching/fitmate.jsp";	
	}
}