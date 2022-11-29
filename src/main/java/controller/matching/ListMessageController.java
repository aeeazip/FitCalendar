package controller.matching;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.Message;
import model.service.ExerciserManager;
import model.service.FitmateManager;
import model.service.MatchingManager;

public class ListMessageController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ListMessageController.class);
	private HttpSession session;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MatchingManager matchingManager = MatchingManager.getInstance();
		FitmateManager messageManager = FitmateManager.getInstance();
		ExerciserManager exManager = ExerciserManager.getInstance();	
		
		session = request.getSession();
		String eId = (String)session.getAttribute("id");
		String fId = (String)request.getParameter("fitmateId");
		if(fId == null)
			fId = (String)session.getAttribute("fitmateId");
		System.out.println(eId + fId);
		
		Exerciser e1 = exManager.findExerciser(eId);
		Exerciser e2 = exManager.findExerciser(fId);
		
		int myId = e1.getExerciserId();
		int fitmateId = e2.getExerciserId();
		System.out.println("MyId : " + myId);
		System.out.println("FitmateId : " + fitmateId);
		
		
		List<Message> sendList = messageManager.getSendMessage(myId, fitmateId);
		List<Message> receiveList = messageManager.getReceiveMessage(fitmateId, myId);
		
		request.setAttribute("sendList", sendList);
		request.setAttribute("receiveList", receiveList);
		
		return "/exerciser/fitmate/messageList.jsp";
	}
}
