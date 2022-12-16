package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.service.ExerciserManager;
import model.service.FitmateManager;
import model.service.RecordManager;

public class WriteMessageController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(MatchingStartController.class);
	private HttpSession session;
	
	int senderId, receiverId;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		
		RecordManager recordManager = RecordManager.getInstance();
		ExerciserManager userManager = ExerciserManager.getInstance();
		FitmateManager fitmateManager = FitmateManager.getInstance();
		
		if (request.getMethod().equals("GET")) {
			// GET request: 메시지 작성 form 요청
			senderId = Integer.parseInt(request.getParameter("senderId"));
			receiverId = Integer.parseInt(request.getParameter("receiverId"));
			
			Exerciser e = userManager.findExerciserById(receiverId);
			String nickname = e.getNickname();

			request.setAttribute("senderId", senderId);
			request.setAttribute("receiverId", receiverId);
			request.setAttribute("nickname", nickname);
	
			return "/exerciser/fitmate/messageForm.jsp"; // messageForm으로 이동
		}

		// POST request (기록 정보가 parameter로 전송됨)
		String content = request.getParameter("content");
		
		try {	
			Exerciser e = userManager.findExerciserById(receiverId);
			request.setAttribute("fitmateId", e.getId());
				
			session.setAttribute("fitmateId", e.getId());
	
			fitmateManager.sendMessage(senderId, receiverId, content);
			return "redirect:/matching/fitmate/message"; // 성공 시 사용자 리스트 화면으로 redirect

		} catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("writeFailed", true);
			request.setAttribute("exception", e);
			return "/exerciser/fitmate/messageForm.jsp";
		}
	}
}
