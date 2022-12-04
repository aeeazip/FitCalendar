package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Exerciser;
import model.service.ExerciserManager;

public class MatchingEndFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ExerciserManager exerciserManager = ExerciserManager.getInstance();
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		Exerciser exerciser = exerciserManager.findExerciser(id);
		
		request.setAttribute("nickname", exerciser.getNickname());
		
		return "/matching/endMatching.jsp";
	}
}
