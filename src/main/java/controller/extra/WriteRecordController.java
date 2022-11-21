package controller.extra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.RecordManager;

public class WriteRecordController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(WriteRecordController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {
			// GET request: 기록 등록 form 요청
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
		int exerciserId = Integer.parseInt(request.getParameter("exerciserId"));

		try {
			RecordManager manager = RecordManager.getInstance();
			manager.insertRecord(title, creationDate, totalTime, category, routine, diet, photo, shareOption,
					exerciserId);
			return "redirect:/myRecord/list"; // 성공 시 사용자 리스트 화면으로 redirect

		} catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("createFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciserId", exerciserId);
			return "/myRecord/recordForm.jsp";
		}
	}
}
