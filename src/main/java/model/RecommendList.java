package model;

public class RecommendList {
	//수정된 부분 -> id 대신 Exerciser 객체를 저장할거임 -> 화면에 Recommend 정보를 띄우기 위한 부분
	int exerciserId;
	int recommend1;
	int recommend2;
	int recommend3;
	int counting;
	
	public RecommendList(int exerciserId, int recommend1) {
		super();
		this.exerciserId = exerciserId;
		this.recommend1 = recommend1;
	}
	
	
	
	public RecommendList(int exerciserId, int recommend1, int recommend2, int recommend3) {
		super();
		this.exerciserId = exerciserId;
		this.recommend1 = recommend1;
		this.recommend2 = recommend2;
		this.recommend3 = recommend3;
	}



	public RecommendList(int exerciserId, int recommend1, int recommend2, int recommend3, int counting) {
		super();
		this.exerciserId = exerciserId;
		this.recommend1 = recommend1;
		this.recommend2 = recommend2;
		this.recommend3 = recommend3;
		this.counting = counting;
	}
	public int getExerciserId() {
		return exerciserId;
	}
	public void setExerciserId(int exerciserId) {
		this.exerciserId = exerciserId;
	}
	public int getRecommend1() {
		return recommend1;
	}
	public void setRecommend1(int recommend1) {
		this.recommend1 = recommend1;
	}
	public int getRecommend2() {
		return recommend2;
	}
	public void setRecommend2(int recommend2) {
		this.recommend2 = recommend2;
	}
	public int getRecommend3() {
		return recommend3;
	}
	public void setRecommend3(int recommend3) {
		this.recommend3 = recommend3;
	}
	public int getCounting() {
		return counting;
	}
	public void setCounting(int counting) {
		this.counting = counting;
	}
	@Override
	public String toString() {
		return "RecommendList [exerciserId=" + exerciserId + ", recommend1=" + recommend1 + ", recommend2=" + recommend2
				+ ", recommend3=" + recommend3 + ", counting=" + counting + "]";
	}
	
}