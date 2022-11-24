package controller.extra;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.ToExercise;
import model.service.StaticManager;

public class CheckToExerciseController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CheckToExerciseController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int exerciserId = Integer.parseInt(request.getParameter("exerciserId"));
		int itemId = Integer.parseInt(request.getParameter("itemId"));

		StaticManager manager = StaticManager.getInstance();

		ArrayList<ToExercise> list = manager.checkToExercise(exerciserId, itemId);

		if (list != null) {
			request.setAttribute("ToExerciseList", list);
			return "redirect:/mypage/ToExercise";
		}

		return " /mypage/ToExercise.jsp";
	}
}
