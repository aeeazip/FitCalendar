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
	
	private static final Logger log = LoggerFactory.getLogger(AllRecordController.class);
	// private int category = 1; // 기본으로 헬스 카테고리 보여주기
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("AllRecordController");

		
		RecordManager manager = RecordManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();
		
		List<String> nickNameList = new ArrayList<String>();
		List<Record> recordList = manager.findAllExerciserRecords();
		
		for(Record r : recordList) {
			Exerciser e = exManager.findExerciserById(r.getExerciserId());
			// System.out.println(i + e.getNickname());
			nickNameList.add(e.getNickname());
		}
		
		// recordList 객체를 request에 저장하여 전달
		request.setAttribute("recordList", recordList);
		request.setAttribute("nickNameList", nickNameList);
		
		
		// 사용자가 작성한 Record 리스트 화면으로 이동(forwarding)
		return "/record/all/list.jsp";
	}

}