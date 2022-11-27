package controller.record;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.service.ExerciserManager;
import model.service.RecordManager;

public class WriteRecordController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(WriteRecordController.class);
	private static HttpSession session;
	String str;
	Exerciser exerciser;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		session = request.getSession();
		
		RecordManager recordManager = RecordManager.getInstance();
		ExerciserManager userManager = ExerciserManager.getInstance();
		
		if (request.getMethod().equals("GET")) {
			// GET request: 기록 등록 form 요청
			str = (String)session.getAttribute("id");
			exerciser = userManager.findExerciser(str);
			
			// System.out.println(str);
			// System.out.println(exerciser.getNickname());
			request.setAttribute("NickName", exerciser.getNickname());
			log.debug("RecordForm Request");
			return "/myRecord/recordForm.jsp"; // registerForm으로 이동
		}

		// POST request (기록 정보가 parameter로 전송됨)
		String title = request.getParameter("title");
		String creationDate = request.getParameter("creationDate");
		int totalTime = Integer.parseInt(request.getParameter("totalTime"));
		int category = Integer.parseInt(request.getParameter("category"));
		String routine = request.getParameter("routine");
		String diet = request.getParameter("diet");
		String photo = request.getParameter("photo");
		int shareOption = Integer.parseInt(request.getParameter("shareOption"));
		int exerciserId = exerciser.getExerciserId();

		
		try {	
			// 1. DB에 Record 정보 등록하기
			recordManager.insertRecord(title, creationDate, totalTime, category, routine, diet, photo, shareOption, exerciserId);
			// 2. 10 포인트 적립하기
			int result = userManager.updatePoint(exerciserId);
			// System.out.println(result);
			
			return "redirect:/myRecord/list"; // 성공 시 사용자 리스트 화면으로 redirect

		} catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("createFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciserId", exerciserId);
			return "/myRecord/recordForm.jsp";
		}
	}
}
