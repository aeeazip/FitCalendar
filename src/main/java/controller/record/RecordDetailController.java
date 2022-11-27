package controller.record;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.Record;
import model.service.ExerciserManager;
import model.service.RecordManager;

// 각각의 기록에 대한 상세 기록 조회
public class RecordDetailController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(RecordDetailController.class);
	private static HttpSession session;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("RecordDetailController");
		
		int recordId = Integer.parseInt(request.getParameter("recordId"));
		System.out.println(recordId);
		
		RecordManager manager = RecordManager.getInstance();
		ExerciserManager userManager = ExerciserManager.getInstance();
		
		Record record = manager.findRecordDetails(recordId);
		int category = record.getCategory();

		session = request.getSession();
		String str = (String)session.getAttribute("id");
		Exerciser exerciser = userManager.findExerciser(str);
		
		// record 객체와 nickname을 request에 저장하여 전달
		request.setAttribute("record", record);
		request.setAttribute("nickname", exerciser.getNickname());
				
		if (category == 1) // 카테고리 : 헬스
			return "/record/health/detail.jsp";
		else if (category == 2) // 카테고리 : 필라테스, 요가
			return "/record/yoga/detail.jsp";
		else if (category == 3) // 카테고리 : 런닝
			return "/record/running/detail.jsp";
		else // 카테고리 : 기타
			return "/record/etc/detail.jsp";
	}

}
