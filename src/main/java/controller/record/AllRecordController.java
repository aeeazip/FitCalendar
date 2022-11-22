package controller.extra;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.RecordManager;

// 전체 사용자의 전체 기록 조회
public class AllRecordController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(AllRecordController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// private static final int countPerPage = 100; // 한 화면에 출력할 사용자 수
		log.debug("AllRecordController");

		/*
		 * String currentPageStr = request.getParameter("currentPage"); int currentPage
		 * = 1; if (currentPageStr != null && !currentPageStr.equals("")) { currentPage
		 * = Integer.parseInt(currentPageStr); }
		 */

		int category = Integer.parseInt(request.getParameter("category"));
		RecordManager manager = RecordManager.getInstance();
		List<Record> recordList = manager.findRecordListByCategory(category);
		// List<User> userList = manager.findUserList(currentPage, countPerPage);

		// recordList 객체를 request에 저장하여 전달
		request.setAttribute("recordList", recordList);

		// 사용자가 작성한 Record 리스트 화면으로 이동(forwarding)
		return "/allRecord/list.jsp";
	}

}