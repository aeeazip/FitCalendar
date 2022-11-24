package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import main.java.Dto.Exerciser;
import main.model.service.MatchingManager;
import main.model.service.exerciserManager;

//Matching 시작버튼 누름 -> useMatchSvc 버튼 값 변경 
public class MatchingStartController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingStartController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MatchingManager matchingManager = MatchingManager.getInstance();
		
		Exerciser exer = new Exerciser();
		
		//useMatchSvc값 변경
		int exerciserId = Integer.parseInt(request.getParameter("exerciserId"));	//수정하려는 exerciserId값
		exer.setUseMatchSvc("T");
		
		matchingManager.createOption(exerciserId, exer.getUseMatchSvc());
		
		return "redirect:matching/setMaxMate";
	}

}
