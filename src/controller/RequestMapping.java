package controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Record.AllRecordController;
import controller.Record.DeleteRecordController;
import controller.Record.ListRecordController;
import controller.Record.RecordDetailController;
import controller.Record.UpdateRecordController;
import controller.Record.WriteRecordController;
import controller.Static.ViewAttendanceController;
import controller.Static.ViewStaticController;
import controller.ToExercise.AddToExerciseController;
import controller.ToExercise.CheckToExerciseController;
import controller.ToExercise.DeleteToExerciseController;
import controller.ToExercise.ViewToExerciseController;
import controller.exerciser.DeleteExerciserController;
import controller.exerciser.RegisterController;
import controller.exerciser.UpdateProfileController;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	// 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		mappings.put("/", new ForwardController("/main/main.jsp"));
		mappings.put("/exerciser/register", new RegisterController());

		mappings.put("/mypage/profile/update", new UpdateProfileController());

		mappings.put("/mypage/delete/form", new ForwardController("/mypage/deleteForm.jsp"));
		mappings.put("/mypage/delete", new DeleteExerciserController());

		mappings.put("/mypage/Attendance", new ForwardController("/mypage/checkAttendance.jsp"));
		mappings.put("/mypage/checkAttendance", new ViewAttendanceController());

		mappings.put("/mypage/ToExercise", new ViewToExerciseController());
		mappings.put("/mypage/ToExercise/add", new AddToExerciseController());
		mappings.put("/mypage/ToExercise/check", new CheckToExerciseController());
		mappings.put("/mypage/ToExercise/delete ", new DeleteToExerciseController());

		mappings.put("/mypage/Statics", new ViewStaticController());
		mappings.put("/mypage/Statics", new ForwardController("/mypage/viewRoutineStatics.jsp"));

		// Record 관련 요청
		mappings.put("/myRecord/write", new WriteRecordController());
		mappings.put("/myRecord/list", new ListRecordController());
		mappings.put("/myRecord/list/detail", new RecordDetailController());
		mappings.put("/myRecord/list/detail/update", new UpdateRecordController());
		mappings.put("/myRecord/list/detail/delete", new DeleteRecordController());
		mappings.put("/myRecord/moveToForm", new ForwardController("/myRecord/recordForm.jsp"));
		mappings.put("/allRecord/list", new AllRecordController());
		mappings.put("/allRecord/list/detail", new RecordDetailController());
		logger.info("Initialized Request Mapping!");
	}

	public Controller findController(String uri) {
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}