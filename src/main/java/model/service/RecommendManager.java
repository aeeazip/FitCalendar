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
	public List<MatchingStatus> showGetRecommendList(int exerciserId) {
		return recommendDao.showGetRecommendList(exerciserId);
	}
	
	//매칭 재추천시 30포인트 차감 + recommend -> 실패 시 0 성공 시 0 이상의 값을 반환함
	public int recommendExerciser(int exerciserId, int height1, int height2, int weight1, int weight2, int percentBodyFat1, int percentBodyFat2){
		System.out.println(exerciserId);
		System.out.println("manager");
		
		Exerciser exerciser = exerciserDao.findExerciser(exerciserId);
		System.out.println(exerciser.getPoint());
		if(exerciser.getPoint() < 30)
			return 0;
		if(recommendDao.usePoint(exerciserId, 30) == 0)
			return 0;
		RecommendList recommendList = recommendDao.recommendExerciser(exerciserId, height1, height2, weight1, weight2, percentBodyFat1, percentBodyFat2);
		System.out.println("manager");
		Exerciser recom1 = exerciserDao.findExerciser(recommendList.getRecommend1());
		Exerciser recom2 = exerciserDao.findExerciser(recommendList.getRecommend2());
		Exerciser recom3 = exerciserDao.findExerciser(recommendList.getRecommend3());
		int maxCount1 = recommendDao.countingMaxMate(recommendList.getRecommend1());
		int maxCount2 = recommendDao.countingMaxMate(recommendList.getRecommend2());
		int maxCount3 = recommendDao.countingMaxMate(recommendList.getRecommend3());
		
		while(maxCount1 != recom1.getMaxMate() && maxCount2 != recom2.getMaxMate() && maxCount3 != recom3.getMaxMate())
			recommendList = recommendDao.recommendExerciser(exerciserId, height1, height2, weight1, weight2, percentBodyFat1, percentBodyFat2);
		
		return 1;
	}
	
	public int reRecommendExerciser(int exerciserId) {
		Exerciser exerciser = exerciserDao.findExerciser(exerciserId);
		System.out.println("RecommendManager");
		if(exerciser.getPoint() < 30)
			return 0;
		if(recommendDao.usePoint(exerciserId, 30) == 0)
			return 0;
		recommendDao.reRecommendExerciser(exerciserId);
		System.out.println("RecommendManager");
		return 1;
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
