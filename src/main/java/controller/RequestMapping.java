package controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.exerciser.DeleteExerciserController;
import controller.exerciser.LoginController;
import controller.exerciser.LogoutController;
import controller.exerciser.RegisterController;
import controller.exerciser.ShowExerciserInfoController;
import controller.matching.ListMessageController;
import controller.matching.MatchingCompleteController;
import controller.matching.MatchingEndFormController;
import controller.matching.MatchingGetRecommendListController;
import controller.matching.MatchingReRequestController;
import controller.matching.MatchingRecommendRefusalController;
import controller.matching.MatchingRequestController;
import controller.matching.MatchingSituationController;
import controller.matching.MatchingStartController;
import controller.matching.MatchingWantListController;
import controller.matching.MatchingWantRecommendController;
import controller.matching.ShowFitmateController;
import controller.matching.ShowMatchingOptionController;
import controller.matching.UpdateMatchOptionController;
import controller.matching.UpdateOptionController;
import controller.matching.WriteMessageController;
import controller.myPage.AddToExerciseController;
import controller.myPage.AttendanceController;
import controller.myPage.CheckToExerciseController;
import controller.myPage.DeleteToExerciseController;
import controller.myPage.MyPageController;
import controller.myPage.ProfileController;
import controller.myPage.StaticController;
import controller.myPage.UnCheckToExerciseController;
import controller.myPage.UpdateProfileController;
import controller.myPage.ViewToExerciseController;
import controller.record.AllRecordController;
import controller.record.AllRecordDetailController;
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
		mappings.put("/", new ForwardController("/main.jsp"));
		mappings.put("/main", new ShowExerciserInfoController());

		mappings.put("/exerciser/register", new RegisterController());
		mappings.put("/exerciser/login", new LoginController());
		mappings.put("/exerciser/logout", new LogoutController());

		// MyPage 관련 요청
		mappings.put("/myPage", new MyPageController());
		mappings.put("/myPage/attendance", new AttendanceController());
		mappings.put("/myPage/static", new StaticController());
		mappings.put("/myPage/profile", new ProfileController());
		mappings.put("/mypage/profile/update", new UpdateProfileController());
		mappings.put("/mypage/delete/form", new DeleteExerciserController());
		mappings.put("/mypage/delete", new DeleteExerciserController());

		// Matching 관련 요청
		mappings.put("/matching/startMatching", new MatchingStartController());
		mappings.put("/matching/matchingMenu", new ShowMatchingOptionController());
		mappings.put("/matching/option", new ForwardController("/matching/setMate.jsp"));
		mappings.put("/matching/option/setMate", new UpdateOptionController());
		mappings.put("/matching/option/setOption", new UpdateMatchOptionController());
		mappings.put("/matching/option/endOption", new MatchingEndFormController());
		mappings.put("/matching/getRecommendList", new MatchingGetRecommendListController());
		mappings.put("/matching/getRecommendList/accept", new MatchingCompleteController());
		mappings.put("/matching/getRecommendList/refuse", new MatchingRecommendRefusalController());
		mappings.put("/matching/wantRecommend", new ForwardController("/matching/wantRecommendForm.jsp"));
		mappings.put("/matching/wantRecommend/form", new MatchingWantRecommendController());
		mappings.put("/matching/wantRecommend/list", new MatchingWantListController());
		mappings.put("/matching/wantRecommend/list/request", new MatchingRequestController());
		mappings.put("/matching/wantRecommend/list/reRequest", new MatchingReRequestController());
		mappings.put("/matching/situation/list", new MatchingSituationController());

		// Fitmate 관련 요청
		mappings.put("/matching/fitmate/message", new ListMessageController());
		mappings.put("/matching/fitmate/message/write", new WriteMessageController());
		mappings.put("/matching/fitmate", new ShowFitmateController());

		// Record 관련 요청
		mappings.put("/myRecord/write", new WriteRecordController());
		mappings.put("/myRecord/list", new ListRecordController());
		mappings.put("/myRecord/list/detail", new RecordDetailController());
		mappings.put("/myRecord/update", new UpdateRecordController());
		mappings.put("/myRecord/delete", new DeleteRecordController());
		mappings.put("/myRecord/moveToForm", new ForwardController("/myRecord/recordForm.jsp"));
		mappings.put("/allRecord/list", new AllRecordController());
		mappings.put("/allRecord/list/detail", new AllRecordDetailController());

		// ToExercise 관련 요청
		mappings.put("/mypage/ToExercise", new ViewToExerciseController());
		mappings.put("/mypage/ToExercise/add", new AddToExerciseController());
		mappings.put("/mypage/ToExercise/check", new CheckToExerciseController());
		mappings.put("/mypage/ToExercise/uncheck", new UnCheckToExerciseController());
		mappings.put("/mypage/ToExercise/delete", new DeleteToExerciseController());

		log.info("Initialized Request Mapping!");

	}

	public Controller findController(String uri) {
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}