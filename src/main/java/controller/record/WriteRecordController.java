package controller.record;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.ExerciserManager;
import model.service.RecordManager;

public class WriteRecordController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(WriteRecordController.class);
	private static HttpSession session;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		session = request.getSession(true);
		if (request.getMethod().equals("GET")) {
			// GET request: 기록 등록 form 요청
			log.debug("RecordForm Request");
			System.out.println(session.getAttribute("id"));
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
		int exerciserId = 2; // Integer.parseInt(request.getParameter("exerciserId"));

		try {
			RecordManager recordManager = RecordManager.getInstance();
			ExerciserManager userManager = ExerciserManager.getInstance();

			// 1. DB에 Record 정보 등록하기
			recordManager.insertRecord(title, creationDate, totalTime, category, routine, diet, photo, shareOption,
					exerciserId);
			// 2. 10 포인트 적립하기
			int result = userManager.updatePoint(exerciserId);
			System.out.println(result + "반환됨");
			System.out.println(session.getAttribute("id"));

			return "/main.jsp";
			// return "redirect:/myRecord/list"; // 성공 시 사용자 리스트 화면으로 redirect

		} catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("createFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciserId", exerciserId);
			return "/myRecord/recordForm.jsp";
		}
	}
}
