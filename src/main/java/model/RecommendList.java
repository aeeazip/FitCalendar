package model;

public class RecommendList {
	//수정된 부분 -> id 대신 Exerciser 객체를 저장할거임 -> 화면에 Recommend 정보를 띄우기 위한 부분
	int exerciserId;
	Exerciser recommend1;
	Exerciser rocommend2;
	Exerciser recommend3;
	
	public RecommendList() {
		super();
	}
	
	public RecommendList(int exerciserId, Exerciser recommend1) {
		super();
		this.exerciserId = exerciserId;
		this.recommend1 = recommend1;
	}

	public RecommendList(int exerciserId, Exerciser recommend1, Exerciser rocommend2, Exerciser recommend3) {
		super();
		this.exerciserId = exerciserId;
		this.recommend1 = recommend1;
		this.rocommend2 = rocommend2;
		this.recommend3 = recommend3;
	}
	public int getExerciserId() {
		return exerciserId;
	}
	public void setExerciserId(int exerciserId) {
		this.exerciserId = exerciserId;
	}
	public Exerciser getRecommend1() {
		return recommend1;
	}
	public void setRecommend1(Exerciser recommend1) {
		this.recommend1 = recommend1;
	}
	public Exerciser getRocommend2() {
		return rocommend2;
	}
	public void setRocommend2(Exerciser rocommend2) {
		this.rocommend2 = rocommend2;
	}
	public Exerciser getRecommend3() {
		return recommend3;
	}
	public void setRecommend3(Exerciser recommend3) {
		this.recommend3 = recommend3;
	}
	@Override
	public String toString() {
		return "RecommendList [exerciserId=" + exerciserId + ", recommend1=" + recommend1 + ", rocommend2=" + rocommend2
				+ ", recommend3=" + recommend3 + "]";
	}
	
	
	
}
