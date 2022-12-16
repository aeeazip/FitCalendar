package controller.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.exerciser.UserSessionUtils;
import model.CompareStatic;
import model.Exerciser;
import model.service.ExerciserManager;
import model.service.StaticManager;

public class StaticController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		System.out.println("22행 : " + UserSessionUtils.getLoginUserId(session));
		String userId = UserSessionUtils.getLoginUserId(session);

		// 로그인한 id의 user의 static 정보를 request 객체에 저장해 뷰에 전달
		ExerciserManager exerciserMgr = ExerciserManager.getInstance();
		StaticManager staticMgr = StaticManager.getInstance();

		// userId로 exerciser의 int id 값 얻어옴 -> 이거로 해당 exerciser의 통계 정보 가져옴
		Exerciser exerciser = exerciserMgr.findExerciser(userId);
		int exerciserId = exerciser.getExerciserId();

		// static 가져오기
		CompareStatic compareStatic = staticMgr.calculateStatic(exerciserId);

		if (compareStatic == null)
			request.setAttribute("error", "출석체크와 인바디 기록을 더 쌓아주세요 !");
		else {

			int weeklyCount = compareStatic.getWeeklyCount();
			int MonthlyCount = compareStatic.getMonthlyCount();
			int ComparePercentFat = compareStatic.getComparePercentFat();
			int CompareMuscle = compareStatic.getCompareMuscle();
			int CompareVisceralFat = compareStatic.getCompareVisceralFat();
			request.setAttribute("weeklyCount", weeklyCount);
			request.setAttribute("MonthlyCount", MonthlyCount);
			request.setAttribute("ComparePercentFat", ComparePercentFat);
			request.setAttribute("CompareMuscle", CompareMuscle);
			request.setAttribute("CompareVisceralFat", CompareVisceralFat);
		}

		return "/myPage/static.jsp";
	}

}
