package controller.record;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.ExerciserSessionUtils;
import model.Exerciser;
import model.Record;
import model.service.ExerciserManager;
import model.service.RecordManager;

// 사용자가 작성한 전체 기록을 조회
public class ListRecordController implements Controller {

	private static final int countPerPage = 5;	// 한 화면에 출력할 Record 수
	private static final Logger log = LoggerFactory.getLogger(ListRecordController.class);
	private static HttpSession session;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("ListRecordController");

		// 로그인 여부 확인
		session = request.getSession();
		String flag = (String)session.getAttribute("id");
		if(flag == null) {
			System.out.println("flag");
			return "redirect:/exerciser/login"; // login form 요청으로 redirect
		}
		
		String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}	
		
		RecordManager manager = RecordManager.getInstance();
		ExerciserManager userManager = ExerciserManager.getInstance();

		String str = (String)session.getAttribute("id");
		Exerciser exerciser = userManager.findExerciser(str);
		int exerciserId = exerciser.getExerciserId();

		List<Record> recordList = manager.findRecordList(exerciserId, currentPage, countPerPage);
		int cnt = manager.findMyRecordCnt(exerciserId);
		int totalP;
		
		if(cnt % countPerPage != 0)
			totalP = cnt / countPerPage + 1;
		else
			totalP = cnt / countPerPage;
		
		// recordList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("recordList", recordList);
		request.setAttribute("cnt", cnt);
		request.setAttribute("nickname", exerciser.getNickname());
		request.setAttribute("totalPage", String.valueOf(totalP));
		request.setAttribute("currentPage", String.valueOf(currentPage));
		
		// 사용자가 작성한 Record 리스트 화면으로 이동(forwarding)
		return "/myRecord/list.jsp";
		
	}
}
