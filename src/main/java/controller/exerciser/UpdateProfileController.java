package controller.exerciser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.service.ExerciserManager;

public class UpdateProfileController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateProfileController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");

		if (request.getMethod().equals("GET")) {
			// GET request: 커뮤니티 수정 form 요청
			ExerciserManager manager = ExerciserManager.getInstance();
			Exerciser exerciser = manager.findExerciserProfile(id);

			request.setAttribute("exerciserId", exerciser.getExerciserId());
			request.setAttribute("id", exerciser.getId());
			request.setAttribute("nickname", exerciser.getNickname());
			request.setAttribute("password", exerciser.getPassword());
			request.setAttribute("explanation", exerciser.getExplanation());
			request.setAttribute("speciality", exerciser.getSpeciality());
			request.setAttribute("personality", exerciser.getPersonality());
			request.setAttribute("gender", exerciser.getGender());
			request.setAttribute("point", exerciser.getPoint());
			request.setAttribute("ranking", exerciser.getRanking());
			request.setAttribute("useMatchSvc", exerciser.getUseMatchSvc());
			request.setAttribute("maxMate", exerciser.getMaxMate());
			return "/mypage/updateProfileForm.jsp";
		}
		// POST request (커뮤니티 정보가 parameter로 전송됨)
		int exerciserId = Integer.parseInt(request.getParameter("exerciserId"));
		int point = Integer.parseInt(request.getParameter("point"));
		int ranking = Integer.parseInt("ranking");
		int maxMate = Integer.parseInt("maxMate");

		Exerciser exerciser = new Exerciser(exerciserId, request.getParameter("id"), request.getParameter("nickname"),
				request.getParameter("password"), request.getParameter("explanation"),
				request.getParameter("speciality"), request.getParameter("personality"), request.getParameter("gender"),
				point, ranking, request.getParameter("useMatchSvc"), maxMate);

		log.debug("Update Profile : {}", exerciser);

		ExerciserManager manager = ExerciserManager.getInstance();
		manager.updateExerciserProfile(exerciser);

		return "redirect:/mypage/profile/update";
	}

}
