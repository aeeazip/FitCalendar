package controller.myPage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.RegisterController;
import model.Exerciser;
import model.service.AttendanceManager;
import model.service.ExerciserManager;

public class AttendanceController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {
			// GET request: 회원정보 등록 form 요청
			log.debug("attendance Request");
			return "/myPage/attendance.jsp";
		}

		// POST request (출석체크 버튼 누르면 이동)
		String att = request.getParameter("attendance");
		System.out.println(att);
		try {
			HttpSession session = request.getSession(true);
			// userId는 로그인한 user의 string id
			System.out.println(session.getAttribute("id"));
			String userId = (String) session.getAttribute("id");
			System.out.println(userId);
			ExerciserManager exerciserMgr = ExerciserManager.getInstance();
			// userId로 exerciser의 int id 값 얻어옴 -> 이거로 출석, point 기록
			Exerciser exerciser = exerciserMgr.findExerciser(userId);
			int exerciserId = exerciser.getExerciserId();
			System.out.println(exerciserId);

			// 해당 exerciserId가 오늘 출석 했으면 못 하게 해야 함
			int confirmAttendance = exerciserMgr.existingAttendance(exerciserId);
			System.out.println("출석: " + confirmAttendance);
			if (confirmAttendance >= 1) {
				// 이미 출석 했으므로 오늘 출석 또 못하게 해야함.
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('이미 출석체크 되었습니다.'); history.go(-2); </script>");
				out.flush();
			} else if (confirmAttendance == 0) {
				int addPoint = exerciserMgr.updatePoint2(exerciserId);
				System.out.println("포인트 추가 성공 여부: " + addPoint);

				System.out.println(att + " 출석 ");

				AttendanceManager attendanceMgr = AttendanceManager.getInstance();
				attendanceMgr.checkAttendance(exerciserId);
				System.out.println("id" + exerciserId + "출석");

				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('출석체크 되었습니다.'); history.go(-2); </script>");

				System.out.println(att + "출석  !!");
				out.flush();
			}
			return "redirect:/myPage";
		} catch (Exception e) {
			request.setAttribute("attendanceFailed", true);
			request.setAttribute("exception", e);
			return "/myPage/attendance.jsp";
		}
	}

}
