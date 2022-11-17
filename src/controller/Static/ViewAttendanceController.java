package controller.Static;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import main.java.Dto.Exerciser;
import main.model.service.staticManager;
import main.model.service.exerciserManager;

public class ViewAttendanceController implements Controller{
	 private static final Logger log = LoggerFactory.getLogger(ViewAttendanceController.class);
	 
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			//해당 날짜가 checking 되었는지 확인하는 변수
		 	int check = Integer.parseInt(request.getParameter("todayAttendance"));
		 	String checkId = request.getParameter("exerciserId");
		 
		 	staticManager s_manager = staticManager.getInstance();		
		 	exerciserManager e_manager = exerciserManager.getInstance();	
		 	
		 	Exerciser exerciser = e_manager.findExerciser(checkId);
			
		 	if(check == 1) {
		 		s_manager.checkAttendance(exerciser.getExerciserId());				
		 	}
		 
		  return "/mypage/checkAttendance.jsp";			
	    }
	
	 

}
