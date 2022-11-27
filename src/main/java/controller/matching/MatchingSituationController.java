package controller.matching;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.exerciser.ExerciserSessionUtils;
import model.Exerciser;
import model.MatchingStatus;
import model.service.ExerciserManager;
import model.service.MatchingManager;

public class MatchingSituationController  implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingSituationController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MatchingManager matchingManager = MatchingManager.getInstance();
		ExerciserManager exerciserManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		Exerciser exerciser = exerciserManager.findExerciser(id);

		List<MatchingStatus> matchingStatus = matchingManager.showSitationList(exerciser.getExerciserId());
		
		List<Exerciser> recieverList = new ArrayList<Exerciser>();
		int recieverId;
		int i = 0;
		Exerciser reciever;
		
		for(MatchingStatus status : matchingStatus) {
			recieverId = status.getReceiver();
			reciever = exerciserManager.findExerciserById(recieverId);
			matchingStatus.get(i).setReceiverNickName(reciever.getNickname());
			
			i++;
		}

		request.setAttribute("matchingStatus", matchingStatus);
	
		return "/matching/situation.jsp";
	}

}

