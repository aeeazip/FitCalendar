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
public class AllRecordDetailController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(RecordDetailController.class);
	private static HttpSession session;
	int recordId, rId;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("RecordDetailController");	

		RecordManager manager = RecordManager.getInstance();
		ExerciserManager userManager = ExerciserManager.getInstance();

		Record record;

		// recordId가 없으니까 parsing할게 없어서 null 뜸 -> 어케 고치냐..
		String param = request.getParameter("recordId");
		
		System.out.println(param);
		if(param != null) {
			recordId = Integer.parseInt(request.getParameter("recordId"));
			record = manager.findRecordDetails(recordId);
			System.out.println(recordId);
		}
		else {
			// System.out.println("열로 들어옴");
			rId = Integer.parseInt((String)session.getAttribute("rId"));	
			System.out.println(session.getAttribute("rId"));
			System.out.println(rId);
			record = manager.findRecordDetails(rId);
		}
		
		int category = record.getCategory();
		System.out.println("category : " + category);
		
		session = request.getSession();
		String str = (String)session.getAttribute("id");
		Exerciser exerciser = userManager.findExerciser(str);

		// record 객체와 nickname을 request에 저장하여 전달
		request.setAttribute("record", record);
		request.setAttribute("nickname", exerciser.getNickname());
		System.out.println(exerciser.getNickname());
		System.out.println(record.getCategory());
				
		return "/record/all/detail.jsp";
	}
}
