package controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.exerciser.LoginController;
import controller.exerciser.RegisterController;
import controller.matching.MatchingStartController;
import controller.matching.ShowMatchingOptionController;
import controller.matching.UpdateOptionController;
import controller.record.AllRecordController;
import controller.record.DeleteRecordController;
import controller.record.ListRecordController;
import controller.record.RecordDetailController;
import controller.record.UpdateRecordController;
import controller.record.WriteRecordController;

public class RequestMapping {
	private static final Logger log = LoggerFactory.getLogger(RequestMapping.class);

	// 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		mappings.put("/", new ForwardController("/index.jsp"));
		mappings.put("/main", new ForwardController("/main.jsp"));

		mappings.put("/exerciser/register", new RegisterController());
		mappings.put("/exerciser/login", new LoginController());
		
		//Matching 관련
		mappings.put("/matching/startMatching", new MatchingStartController());
		mappings.put("/matching/setMate", new UpdateOptionController());
		mappings.put("/matching/setOptions", new UpdateOptionController());// option설정은 같은 Controller에서 처리
		mappings.put("/matching/matchingMenu/options", new ShowMatchingOptionController());
		
		
		
		
		/*
		 * mappings.put("/mypage/profile/update", new UpdateProfileController());
		 * 
		 * mappings.put("/mypage/delete/form", new
		 * ForwardController("/mypage/deleteForm.jsp")); mappings.put("/mypage/delete",
		 * new DeleteExerciserController());
		 * 
		 * mappings.put("/mypage/Attendance", new
		 * ForwardController("/mypage/checkAttendance.jsp"));
		 * mappings.put("/mypage/checkAttendance", new ViewAttendanceController());
		 * 
		 * mappings.put("/mypage/ToExercise", new ViewToExerciseController());
		 * mappings.put("/mypage/ToExercise/add", new AddToExerciseController());
		 * mappings.put("/mypage/ToExercise/check", new CheckToExerciseController());
		 * mappings.put("/mypage/ToExercise/delete ", new DeleteToExerciseController());
		 * 
		 * mappings.put("/mypage/Statics", new ViewStaticController());
		 * mappings.put("/mypage/Statics", new
		 * ForwardController("/mypage/viewRoutineStatics.jsp"));
		 * 
		 */
		 // Record 관련 요청 
		 mappings.put("/myRecord/write", new WriteRecordController());
		 mappings.put("/myRecord/list", new ListRecordController());
		 mappings.put("/myRecord/list/detail", new RecordDetailController());
		 mappings.put("/myRecord/list/detail/update", new UpdateRecordController());
		 mappings.put("/myRecord/list/detail/delete", new DeleteRecordController());
		 mappings.put("/myRecord/moveToForm", new ForwardController("/myRecord/recordForm.jsp"));
		 mappings.put("/allRecord/list", new AllRecordController());
		 mappings.put("/allRecord/list/detail", new RecordDetailController());
		 
		 log.info("Initialized Request Mapping!");
		
	}

	public Controller findController(String uri) {
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}