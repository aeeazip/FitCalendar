package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Exerciser;
import model.Inbody;
import model.service.InbodyManager;
import model.service.exerciserManager;

public class RegisterController implements Controller {

	private int exerciserid;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getMethod().equals("GET")) {
			// GET request: 회원정보 등록 form 요청
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

		Exerciser exerciser = new Exerciser(id, password, nickname, explanation, speciality, personality, gender);
		System.out.println(exerciser);

		try {
			exerciserManager manager = exerciserManager.getInstance();
			manager.insertExerciser(password, nickname, explanation, speciality, personality, gender, id);
			exerciserid = manager.findExerciser(id).getExerciserId();
			System.out.println(exerciserid);
		} catch (Exception e) {
			// 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciser", exerciser);
			return "exerciser/registerForm.jsp";
		}

		// 바로 생성한 exerciser 객체의 exerciserId를 저장 -> 해당 exerciserid에 inbody 정보 추가
		int height = Integer.parseInt(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		int percentBodyFat = Integer.parseInt(request.getParameter("percentBodyFat"));
		int skeletalMM = Integer.parseInt(request.getParameter("skeletalMM"));
		int visceralFat = Integer.parseInt(request.getParameter("visceralFat"));
		String measureDate = request.getParameter("measureDate");

		Inbody inbody = new Inbody(height, weight, percentBodyFat, skeletalMM, visceralFat, measureDate, exerciserid);
		System.out.println(inbody);

		try {
			InbodyManager mgr = InbodyManager.getInstance();
			mgr.insertInbody(height, weight, percentBodyFat, skeletalMM, visceralFat, measureDate, exerciserid);
			return "main/main.jsp";
//			login 만들고 로그인 페이지로 가도록 수정하기
		} catch (Exception e) {
			request.setAttribute("InbodyInsertFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("inbody", inbody);
			return "main/main.jsp";
//			login 만들고 로그인 페이지로 가도록 수정하기
		}

	}

}