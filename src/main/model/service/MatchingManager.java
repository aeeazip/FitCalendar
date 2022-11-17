package main.model.service;

import java.sql.SQLException;
import java.util.List;

import main.java.Dao.ExerciserDao;
import main.java.Dto.Exerciser;
import main.java.Matching.Dao.MatchingDao;
import main.java.Matching.Dto.MatchingStatus;

public class MatchingManager {
	private static MatchingManager matchingMan = new MatchingManager();
	private MatchingDao matchingDao;
	private ExerciserDao exerciserDao;
	
	private MatchingManager() {
		try {
			exerciserDao = new ExerciserDao();
			matchingDao = new MatchingDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MatchingManager getInstance() {
		return matchingMan;
	}
	
	public int createOption(int exerciserId, String useMatchSvc) throws SQLException {
		return matchingDao.createOption(exerciserId, useMatchSvc);
	}
	
	public int optionChange(int exerciserId, int maxMate) {
		return matchingDao.optionChange(exerciserId, maxMate);
	}
	
	public Exerciser showOption(int exerciserId, int useMatchSvc, int maxMate) {
		Exerciser exerciser = matchingDao.showOption(exerciserId);
		return exerciser;
	}
	
	public int acceptRecommend(int myExerciserId, int yourExerciserId) {
		return matchingDao.acceptRecommend(myExerciserId, yourExerciserId);
	}
	
	public int notifyMatching(int myExerciserId, int yourExerciserId) {
		return matchingDao.notifyMatching(myExerciserId, yourExerciserId);
	}
	
	public int matchingComplete(int myExerciserId, int yourExerciserId) {
		return matchingDao.matchingComplete(myExerciserId, yourExerciserId);
	}
	
	public int matchingRefuse(int myExerciserId, int yourExerciserId) {
		return matchingDao.matchingRefuse(myExerciserId, yourExerciserId);
	}
	
	public int refuseRecommend(int myExerciserId, int yourExerciserId) {
		return matchingDao.refuseRecommend(myExerciserId, yourExerciserId);
	}
	
	public List<MatchingStatus> showSitationList(int exerciserId){
		return matchingDao.showSitationList(exerciserId);
	}

}
