
package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.service.ExerciserManager;
import model.service.RecommendManager;

public class MatchingWantRecommendController_serve implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingWantRecommendController_serve.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RecommendManager recommendManager = RecommendManager.getInstance();
		ExerciserManager exerciserManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		System.out.println("matchingController: " + id);

		System.out.println("matchingWantRecommendController");
		Exerciser exerciser = exerciserManager.findExerciser(id);
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String percentBodyFat = request.getParameter("percentBodyFat");
		System.out.println(height);

		int height_option = Integer.parseInt(height);
		int weight_option = Integer.parseInt(weight);
		int percentBodyFat_option = Integer.parseInt(percentBodyFat);

		System.out.println(height_option);

		int height1 = 0, height2 = 0;
		int weight1 = 0, weight2 = 0;
		int percentBodyFat1 = 0, percentBodyFat2 = 0;

		switch (height_option) {
		case 1:
			height1 = 150;
			height2 = 159;
			break;

		case 2:
			height1 = 160;
			height2 = 169;
			break;
		case 3:
			height1 = 170;
			height2 = 179;
			break;
		case 4:
			height1 = 180;
			height2 = 200;
			break;

		}

		switch (weight_option) {
		case 1:
			weight1 = 40;
			weight2 = 49;
			break;

		case 2:
			weight1 = 50;
			weight2 = 59;
			break;
		case 3:
			weight1 = 60;
			weight2 = 69;
			break;
		case 4:
			weight1 = 70;
			weight2 = 79;
			break;
		case 5:
			weight1 = 80;
			weight2 = 89;
			break;
		case 6:
			weight1 = 90;
			weight2 = 150;
			break;

		}

		switch (percentBodyFat_option) {
		case 1:
			percentBodyFat1 = 0;
			percentBodyFat2 = 14;
			break;

		case 2:
			percentBodyFat1 = 15;
			percentBodyFat2 = 24;
			break;
		case 3:
			percentBodyFat1 = 25;
			percentBodyFat2 = 34;
			break;
		case 4:
			percentBodyFat1 = 35;
			percentBodyFat2 = 50;
			break;

		}
		System.out.println(height1);
		int result = recommendManager.recommendExerciser(exerciser.getExerciserId(), height1, height2, weight1, weight2,
				percentBodyFat1, percentBodyFat2);
		System.out.println(result);
		try {
			if (result != 0)
				return "redirect:/matching/wantRecommend/list";
		} catch (Exception e) {
			request.setAttribute("MatchingFailed", true);
			request.setAttribute("exerciser", exerciser);
		}

		return "redirect:/matching/wantRecommend/list";
	}

}
