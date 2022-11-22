package controller.extra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.ExerciserSessionUtils;
import model.Exerciser;
import model.service.RecordManager;
import model.service.exerciserManager;

public class UpdateRecordController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(UpdateRecordController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {
			// GET request: 기록 수정 form 요청
			log.debug("RecordUpdateForm Request");

			int recordId = Integer.parseInt(request.getParameter("recordId"));

			RecordManager manager = RecordManager.getInstance();
			Record record = manager.findRecordDetails(recordId); // recordId로 사용자가 작성한 Record 정보를 가져온다
			request.setAttribute("record", record);

			exerciserManager exMgr = exerciserManager.getInstance();
			// record의 int형 exerciserId로 String id값을 가져와야 함.
			Exerciser exerciser = exMgr.findExerciserById(record.getExerciserId());

			HttpSession session = request.getSession();
			if (ExerciserSessionUtils.getLoginUserId(session).equals(exerciser.getId())) {
				// 현재 로그인한 사용자가 수정 대상 사용자인 경우 -> 수정 가능
				return "/myRecord/list/detail/updateForm.jsp"; // 검색한 사용자 정보 및 커뮤니티 리스트를 updateForm으로 전송
			}
			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", new IllegalStateException("타인의 정보는 수정할 수 없습니다."));

			return "/myRecord/list/detail/updateForm.jsp"; // registerForm으로 이동
		}

		// POST request (기록 수정 정보가 parameter로 전송됨)
		int recordId = Integer.parseInt(request.getParameter("recordId"));
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
			manager.updateRecord(recordId, title, creationDate, totalTime, category, routine, diet, photo, shareOption,
					exerciserId);
			return "redirect:/myRecord/list/detail"; // 성공 시 사용자 리스트 화면으로 redirect

		} catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("recordId", recordId);
			return "/myRecord/list/detail.jsp"; // record 상세 정보를 보여주는 페이지로 이동
		}
	}

}