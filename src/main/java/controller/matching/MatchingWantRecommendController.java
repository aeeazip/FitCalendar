
package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.HeightRange;
import model.PercentBodyFatRange;
import model.WeightRange;
import model.service.ExerciserManager;
import model.service.RecommendManager;

public class MatchingWantRecommendController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MatchingWantRecommendController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RecommendManager recommendManager = RecommendManager.getInstance();
		ExerciserManager exerciserManager = ExerciserManager.getInstance();

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");

		Exerciser exerciser = exerciserManager.findExerciser(id);
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		String percentBodyFat = request.getParameter("percentBodyFat");

		int height_option = Integer.parseInt(height);
		int weight_option = Integer.parseInt(weight);
		int percentBodyFat_option = Integer.parseInt(percentBodyFat);


		WeightRange w_range;
		HeightRange h_range;
		PercentBodyFatRange p_range;
		
		w_range = recommendManager.calculateWeightrange(weight_option);
		h_range = recommendManager.calculateHeightrange(height_option);
		p_range = recommendManager.calculatePercentBodyFatrange(percentBodyFat_option);

		
		int result = recommendManager.recommendExerciser(exerciser.getExerciserId(), h_range.getHeight1(), h_range.getHeight2(), 
				w_range.getWeight1(), w_range.getWeight2(),
				p_range.getPercentBodyFat1(), p_range.getPercentBodyFat2());

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
