package controller.matchingOptionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import main.java.Dto.Exerciser;

//Matching 시작버튼 누름 -> useMatchSvc 버튼 값 넘어옴
public class MatchingCreateOptionController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingCreateOptionController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Exerciser exerciser = new Exerciser(request.getParameter("useMatchSvc"));
		
		/*try {
			
		} catch() {*/
			
		return null;
	}
	
	
}
