package controller.exerciser;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.Inbody;
import model.service.ExerciserManager;
import model.service.ExistingUserException;
import model.service.InbodyManager;

public class RegisterController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

	private int exerciserid;

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
		log.debug("Create exerciser : {}", exerciser);

		try {
			ExerciserManager manager = ExerciserManager.getInstance();
			manager.insertExerciser(password, nickname, explanation, personality, speciality, gender, id);
			exerciserid = manager.findExerciser(id).getExerciserId();
			System.out.println(exerciserid);
		} catch (ExistingUserException e) {
			// 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciser", exerciser);
			System.out.println("ExistingUserException 예외 발생");
			return "redirect:/exerciser/register";
		}

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

		Inbody inbody = new Inbody(height, weight, percentBodyFat, skeletalMM, visceralFat, measureDate, exerciserid);

		try {
			InbodyManager mgr = InbodyManager.getInstance();
			mgr.insertInbody(height, weight, percentBodyFat, skeletalMM, visceralFat, measureDate, exerciserid);
			// alert창
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입 되었습니다.'); location.href='../exerciser/login'; </script>");

			out.flush();
			return "/exerciser/loginForm.jsp";
		} catch (Exception e) {
			request.setAttribute("InbodyInsertFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("inbody", inbody);
			return "redirect:/exerciser/register";
		}

	}

}