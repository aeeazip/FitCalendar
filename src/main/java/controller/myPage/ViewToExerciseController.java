package controller.myPage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.ToExercise;
import model.service.ExerciserManager;
import model.service.ToExerciseManager;

public class ViewToExerciseController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewToExerciseController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExerciserManager exerciserManager = ExerciserManager.getInstance();
		ToExerciseManager toExerciserManager = ToExerciseManager.getInstance();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		Exerciser exerciser = exerciserManager.findExerciser(id);
		
		ArrayList<ToExercise> list = toExerciserManager.findToExercise(exerciser.getExerciserId());
		
		for(ToExercise item : list) {
			System.out.println(item.toString());
		}

		if (list != null) {
			request.setAttribute("ToExerciseList", list);
			return "/myPage/ToExercise.jsp";
		}

		return "/myPage/ToExercise.jsp";
	}

}
