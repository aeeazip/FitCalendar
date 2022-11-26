package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.ExerciserSessionUtils;
import model.Exerciser;
import model.service.ExerciserManager;
import model.service.MatchingManager;

//MatMate 값 변경
public class UpdateOptionController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(MatchingStartController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MatchingManager manager = MatchingManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();
		
		//로그인한 사용자의 exerciser 객체
		//Exerciser exerciser = exManager.findExerciser(ExerciserSessionUtils.getLoginUserId(session));
		Exerciser exerciser = new Exerciser(12);
		int id = exerciser.getExerciserId();
		
		//둘 다 maxMate 바꿀수 있어서 뺏음.
		int maxMate = Integer.getInteger(request.getParameter("maxMate"));
		
		//maxMate 설정하기
		if(request.getServletPath().equals("/matching/setMate")) {
			try {
				//manager.optionChange(exerciser.getExerciserId(), maxMate, "T");
				 manager.optionChange(12, maxMate, "T");
				return "/matching/setMate.jsp"; //성공 시, 해당 페이지로 forwarding 	
			} catch (Exception e) {
				request.setAttribute("checkFailed", true);
				request.setAttribute("exception", e);
				request.setAttribute("exerciserId", exerciser.getExerciserId());
				return "redirect:/matching/setMate"; //실패 시, 다시  maxMate설정 페이지로!(안넘어가게)
			}
		} 
		
		//option(매칭 설정 취소 or maxMate 재설정) 전체 설정
		else if(request.getServletPath().equals("/matching/setOptions")) {
			String useMatchSvc = request.getParameter("useMatchSvc");
			try {
				//manager.optionChange(exerciser.getExerciserId(), maxMate, useMatchSvc);
				manager.optionChange(12, maxMate, useMatchSvc);
				return "/matching/setOptions.jsp"; //성공하면 matchingMenu로 이동
			} catch (Exception e) {
				return "redirect:/matching/matchingMenu";	//실패하면 다시 changeOptions해주기.
			}
		}
		return "redirect:/matching/matchingMenu"; //다 안되면 걍 메뉴로 이동.
		
	}
}
