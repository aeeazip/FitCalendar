package controller.record;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.ExerciserSessionUtils;
import model.service.RecordManager;
import model.Record;

// 사용자가 작성한 전체 기록을 조회
public class ListRecordController implements Controller {

	// private static final int countPerPage = 100; // 한 화면에 출력할 사용자 수
	private static final Logger log = LoggerFactory.getLogger(ListRecordController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("ListRecordController");
		// 로그인 여부 확인
		if (!ExerciserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/exerciser/loginForm.jsp"; // login form 요청으로 redirect
		}

		/*
		 * String currentPageStr = request.getParameter("currentPage"); int currentPage
		 * = 1; if (currentPageStr != null && !currentPageStr.equals("")) { currentPage
		 * = Integer.parseInt(currentPageStr); }
		 */

		int exerciserId = Integer.parseInt(request.getParameter("exerciserId"));
		RecordManager manager = RecordManager.getInstance();
		List<Record> recordList = manager.findRecordList(exerciserId);
		// List<User> userList = manager.findUserList(currentPage, countPerPage);

		// recordList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("recordList", recordList);
		request.setAttribute("exerciserId", ExerciserSessionUtils.getLoginUserId(request.getSession()));

		// 사용자가 작성한 Record 리스트 화면으로 이동(forwarding)
		return "/myRecord/list.jsp";
	}

}
