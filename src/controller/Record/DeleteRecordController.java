package controller.Record;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.ExerciserSessionUtils;
import main.java.Dto.Exerciser;
import main.java.Record.Dto.Record;
import main.model.service.RecordManager;
import main.model.service.exerciserManager;


public class DeleteRecordController implements Controller{
	
	private static final Logger log = LoggerFactory.getLogger(DeleteRecordController.class);
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		log.debug("Delete Record Request");
		
		int recordId = Integer.parseInt(request.getParameter("recordId"));
		
		RecordManager manager = RecordManager.getInstance();
		Record record = manager.findRecordDetails(recordId); // recordId로 사용자가 작성한 Record 정보를 가져온다
		
		exerciserManager exMgr = exerciserManager.getInstance();
		Exerciser exerciser = exMgr.findExerciserById(record.getExerciserId());
		
		HttpSession session = request.getSession();	
		if (ExerciserSessionUtils.getLoginUserId(session).equals(exerciser.getId())) {
			// 현재 로그인한 사용자가 수정 대상 사용자인 경우 -> 수정 가능
			int result = manager.deleteRecord(recordId);
			if(result == 1)
				return "redirect:/myRecord/list"; // 삭제 성공 시 나의 전체 기록을 조회하는 화면으로 이동
		} 
		
		/* 삭제가 불가능한 경우 */
		request.setAttribute("exception", new IllegalStateException("삭제에 실패했습니다."));  
		request.setAttribute("recordId", recordId);
		return "redirect:/myRecord/list"; // 삭제하려던 Record 상세 기록 페이지로 이동				
	}

}
