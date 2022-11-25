package model.service;

import model.dao.ExerciserDao;
import model.dao.RecommendDao;

import java.util.List;

import model.*;

public class RecommendManager {
	private static RecommendManager recommendManager = new RecommendManager();
	private RecommendDao recommendDao;
	private ExerciserDao exerciserDao;

	private RecommendManager() {
		try {
			exerciserDao = new ExerciserDao();
			recommendDao = new RecommendDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RecommendManager getInstance() {
		return recommendManager;
	}
	
	//login한 exerciser를 매칭 신청한 list보기
	public List<RecommendList> showGetRecommendList(int exerciserId) {
		return recommendDao.showGetRecommendList(exerciserId);
	}
	
	//매칭 재추천시 30포인트 차감 + recommend -> 실패 시 0 성공 시 0 이상의 값을 반환함
	public int recommendExerciser(int exerciserId){
		if(recommendDao.usePoint(exerciserId, 30) != 0)
		return recommendDao.recommendExerciser(exerciserId);
		return 0;
	}
	
	public int reRecommendExerciser(int exerciserId, int recomId1, int recomId2, int recomId3) {
		if(recommendDao.usePoint(exerciserId, 30) != 0)
			return recommendDao.reRecommendExerciser(exerciserId, recomId1, recomId2, recomId3);
		return 0;
	}
	
	//RecommendList return -> recommendList DTO 수정
	public RecommendList displayExerciser(int exerciserId){
		return recommendDao.displayExerciser(exerciserId);
	}
	
	//Fitmate 요청
	public int requestFitmate(int exerciserId, int wantRecommId) {
		return recommendDao.requestFitmate(exerciserId, wantRecommId);
	}
}
