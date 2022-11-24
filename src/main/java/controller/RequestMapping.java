package controller;

import java.util.HashMap;
import java.util.Map;

import controller.exerciser.LoginController;
import controller.exerciser.RegisterController;
import controller.matching.MatchingStartController;
import controller.matching.UpdateMaxMateController;

public class RequestMapping {
//	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	// 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		mappings.put("/", new ForwardController("/index.jsp"));
		mappings.put("/main", new ForwardController("/main.jsp"));

		mappings.put("/exerciser/register", new RegisterController());
		mappings.put("/exerciser/login", new LoginController());
		

		mappings.put("/matching/startMatching", new MatchingStartController());
		mappings.put("/matching/setMate", new UpdateMaxMateController());
		
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
		 * // Record 관련 요청 mappings.put("/myRecord/write", new WriteRecordController());
		 * mappings.put("/myRecord/list", new ListRecordController());
		 * mappings.put("/myRecord/list/detail", new RecordDetailController());
		 * mappings.put("/myRecord/list/detail/update", new UpdateRecordController());
		 * mappings.put("/myRecord/list/detail/delete", new DeleteRecordController());
		 * mappings.put("/myRecord/moveToForm", new
		 * ForwardController("/myRecord/recordForm.jsp"));
		 * mappings.put("/allRecord/list", new AllRecordController());
		 * mappings.put("/allRecord/list/detail", new RecordDetailController());
		 * logger.info("Initialized Request Mapping!");
		 */
	}

	public Controller findController(String uri) {
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}