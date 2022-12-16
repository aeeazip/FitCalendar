package controller.myPage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.UserSessionUtils;
import model.Exerciser;
import model.Inbody;
import model.service.ExerciserManager;
import model.service.InbodyManager;

public class UpdateProfileController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateProfileController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		System.out.println("24행 : " + session.getAttribute("id"));
		System.out.println("25행 : " + UserSessionUtils.getLoginUserId(session));
		String id = UserSessionUtils.getLoginUserId(session);
		if (request.getMethod().equals("GET")) {
			// GET request: 프로필 수정 form 요청

			// 로그인한 id의 exerciser정보를 request 객체에 저장해 뷰에 전달
			ExerciserManager exerciserMgr = ExerciserManager.getInstance();
			// userId로 exerciser의 int id 값 얻어옴 -> 이거로 해당 exerciser의 정보 가져옴
			Exerciser exerciser = exerciserMgr.findExerciser(id);
			int exerciserId = exerciser.getExerciserId();

			String exerciserid = exerciser.getId();
			String nickname = exerciser.getNickname();
			String explanation = exerciser.getExplanation();
			String personality = exerciser.getPersonality();
			String speciality = exerciser.getSpeciality();
			String gender = exerciser.getGender();
			request.setAttribute("exerciserid", exerciserid);
			request.setAttribute("nickname", nickname);
			request.setAttribute("explanation", explanation);
			request.setAttribute("personality", personality);
			request.setAttribute("speciality", speciality);
			request.setAttribute("gender", gender);

			// inbody 정보 가져옴
			InbodyManager inbodyMgr = InbodyManager.getInstance();
			Inbody inbody = inbodyMgr.findInbody(exerciserId);
			System.out.println("54행 : " + inbody);

			int height = inbody.getHeight();
			int weight = inbody.getWeight();
			int percentBodyFat = inbody.getPercentBodyFat();
			int skeletalMM = inbody.getSkeletalMM();
			int visceralFat = inbody.getVisceralFat();
			String measureDate = inbody.getMeasureDate();

			request.setAttribute("height", height);
			request.setAttribute("weight", weight);
			request.setAttribute("percentBodyFat", percentBodyFat);
			request.setAttribute("skeletalMM", skeletalMM);
			request.setAttribute("visceralFat", visceralFat);
			request.setAttribute("measureDate", measureDate);

			return "/myPage/updateProfileForm.jsp";
		}

		// POST request (커뮤니티 정보가 parameter로 전송됨)
		ExerciserManager exerciserMgr = ExerciserManager.getInstance();
		Exerciser exerciser = exerciserMgr.findExerciser(id);
		int exerciserId = exerciser.getExerciserId();

		int result1 = exerciserMgr.updateExerciser(exerciserId, request.getParameter("nickname"),
				request.getParameter("explanation"), request.getParameter("speciality"),
				request.getParameter("personality"));

		InbodyManager inbodyMgr = InbodyManager.getInstance();

		int result2 = inbodyMgr.insertInbody(Integer.parseInt(request.getParameter("height")),
				Integer.parseInt(request.getParameter("weight")),
				Integer.parseInt(request.getParameter("percentBodyFat")),
				Integer.parseInt(request.getParameter("skeletalMM")),
				Integer.parseInt(request.getParameter("visceralFat")), request.getParameter("measuredate"),
				exerciserId);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('수정 되었습니다.'); history.go(-2); </script>");

		out.flush();

		return "redirect:/myPage";
	}

}
