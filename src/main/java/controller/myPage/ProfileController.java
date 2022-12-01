package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.exerciser.UserSessionUtils;
import model.Exerciser;
import model.Inbody;
import model.service.ExerciserManager;
import model.service.InbodyManager;

public class ProfileController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		System.out.println("19행 : " + session.getAttribute("id"));
		System.out.println("20행 : " + UserSessionUtils.getLoginUserId(session));
		String id = UserSessionUtils.getLoginUserId(session);

		// 로그인한 id의 user 정보를 request 객체에 저장해 뷰에 전달
		ExerciserManager exerciserMgr = ExerciserManager.getInstance();
		// userId로 exerciser의 int id 값 얻어옴 -> 이거로 해당 exerciser의 정보 가져옴
		Exerciser exerciser = exerciserMgr.findExerciser(id);
		int exerciserId = exerciser.getExerciserId();
		System.out.println("28행 : " + exerciserId);
		System.out.println("29행 : " + exerciser);

		String exerciserid = exerciser.getId();
		String nickname = exerciser.getNickname();
		String explanation = exerciser.getExplanation();
		String personality = exerciser.getPersonality();
		String speciality = exerciser.getSpeciality();
		String gender = exerciser.getGender();
		System.out.println("39행 : " + exerciserid);
		System.out.println("40행 : " + nickname);
		System.out.println("41행 : " + explanation);
		System.out.println("42행 : " + personality);
		System.out.println("43행 : " + speciality);
		System.out.println("44행 : " + gender);

		request.setAttribute("exerciserid", exerciserid);
		request.setAttribute("nickname", nickname);
		request.setAttribute("explanation", explanation);
		request.setAttribute("personality", personality);
		request.setAttribute("speciality", speciality);
		request.setAttribute("gender", gender);

		// inbody 정보 가져옴
		InbodyManager inbodyMgr = InbodyManager.getInstance();
		Inbody inbody = inbodyMgr.findInbody(exerciserId);
		System.out.println("56행 : " + inbody);

		int height = inbody.getHeight();
		int weight = inbody.getWeight();
		int percentBodyFat = inbody.getPercentBodyFat();
		int skeletalMM = inbody.getSkeletalMM();
		int visceralFat = inbody.getVisceralFat();
		String measureDate = inbody.getMeasureDate();
		System.out.println("64행 : " + height);
		System.out.println("65행 : " + weight);
		System.out.println("66행 : " + percentBodyFat);
		System.out.println("67행 : " + skeletalMM);
		System.out.println("68행 : " + visceralFat);
		System.out.println("69행 : " + measureDate);

		request.setAttribute("height", height);
		request.setAttribute("weight", weight);
		request.setAttribute("percentBodyFat", percentBodyFat);
		request.setAttribute("skeletalMM", skeletalMM);
		request.setAttribute("visceralFat", visceralFat);
		request.setAttribute("measureDate", measureDate);

		return "/myPage/profile.jsp";
	}

}
