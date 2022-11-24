package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.MatchingManager;


public class UpdateMaxMateController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int exerciserId = Integer.parseInt(request.getParameter("exerciserId"));
		int maxMate = Integer.parseInt("maxMate");
		
		try {
			MatchingManager manager = MatchingManager.getInstance();
			manager.optionChange(exerciserId, maxMate);
			return "redirect:/matching/startMatching"; //성공 시, 해당 페이지로 redirect 
		} catch (Exception e) {
			request.setAttribute("checkFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciserId", exerciserId);
			return "/matching/setMaxMate.jsp"; //실패 시, 다시 maxMate설정 페이지로!
		}
	}
	
}
