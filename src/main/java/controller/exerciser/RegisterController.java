package controller.exerciser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.Inbody;
import model.service.InbodyManager;
import model.service.ExerciserManager;

public class RegisterController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

	private int exerciserid;
//	private int inbodyid;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getMethod().equals("GET")) {
			// GET request: 회원정보 등록 form 요청
			log.debug("RegisterForm Request");
			return "/exerciser/registerForm.jsp";
		}

		// POST request (회원정보가 parameter로 전송됨)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String explanation = request.getParameter("explanation");
		String speciality = request.getParameter("speciality");
		String personality = request.getParameter("personality");
		String gender = request.getParameter("gender");

		Exerciser exerciser = new Exerciser(id, password, nickname, explanation, personality, speciality, gender);
		System.out.println(exerciser);
		log.debug("Create exerciser : {}", exerciser);

		try {
			ExerciserManager manager = ExerciserManager.getInstance();
			manager.insertExerciser(password, nickname, explanation, personality, speciality, gender, id);
			exerciserid = manager.findExerciser(id).getExerciserId();
			System.out.println(exerciserid);
		} catch (Exception e) {
			// 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciser", exerciser);
			return "/exerciser/register.jsp";
		}

//		System.out.println(request.getParameter("height"));
//		System.out.println(Integer.parseInt(request.getParameter("height")));
		// 바로 생성한 exerciser 객체의 exerciserId를 저장 -> 해당 exerciserid에 inbody 정보 추가
		int height = Integer.parseInt(request.getParameter("height"));
		System.out.println(height);
		int weight = Integer.parseInt(request.getParameter("weight"));
		System.out.println(weight);
		int percentBodyFat = Integer.parseInt(request.getParameter("percentbodyfat"));
		System.out.println(percentBodyFat);
		int skeletalMM = Integer.parseInt(request.getParameter("skeletalmm"));
		System.out.println(skeletalMM);
		int visceralFat = Integer.parseInt(request.getParameter("visceralfat"));
		System.out.println(visceralFat);
		String measureDate = request.getParameter("measuredate");
		System.out.println(measureDate);

//		System.out.println(height + weight + percentBodyFat + skeletalMM + visceralFat + measureDate);
		Inbody inbody = new Inbody(height, weight, percentBodyFat, skeletalMM, visceralFat, measureDate, exerciserid);
		System.out.println(inbody);

		try {
			InbodyManager mgr = InbodyManager.getInstance();
			mgr.insertInbody(height, weight, percentBodyFat, skeletalMM, visceralFat, measureDate, exerciserid);
			return "/main.jsp";
//			login 만들고 로그인 페이지로 가도록 수정하기
		} catch (Exception e) {
			request.setAttribute("InbodyInsertFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("inbody", inbody);
			return "/exerciser/register.jsp";
//			login 만들고 로그인 페이지로 가도록 수정하기
		}

	}

}