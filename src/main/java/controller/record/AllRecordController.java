package controller.record;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.Record;
import model.service.ExerciserManager;
import model.service.RecordManager;

// 전체 사용자의 전체 기록 조회
public class AllRecordController implements Controller {
	private static final int countPerPage = 5;	// 한 화면에 출력할 Record 수
	private static final Logger log = LoggerFactory.getLogger(AllRecordController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("AllRecordController");

		
    	String currentPageStr = request.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}		
		
		RecordManager manager = RecordManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();
		
		List<String> nickNameList = new ArrayList<String>();
		List<Record> recordList = manager.findAllExerciserRecords(currentPage, countPerPage);
		
		for(Record r : recordList) {
			Exerciser e = exManager.findExerciserById(r.getExerciserId());
			nickNameList.add(e.getNickname());
		}
		
		int totalP = manager.getTotalPages(countPerPage);
		System.out.println("AllRecordController : " + totalP);
		
		// recordList 객체를 request에 저장하여 전달
		request.setAttribute("recordList", recordList);
		request.setAttribute("nickNameList", nickNameList);
		request.setAttribute("totalP", String.valueOf(totalP));
		request.setAttribute("currentPage", String.valueOf(currentPage));
		
		// 사용자가 작성한 Record 리스트 화면으로 이동(forwarding)
		return "/record/all/list.jsp";
	}

}