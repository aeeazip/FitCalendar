package model;

public class RecommendList {
	//수정된 부분 -> id 대신 Exerciser 객체를 저장할거임 -> 화면에 Recommend 정보를 띄우기 위한 부분
	Exerciser exerciser;
	Exerciser recommend1;
	Exerciser recommend2;
	Exerciser recommend3;
	int counting;
	public RecommendList() {
		super();
	}
	
	public RecommendList(Exerciser exerciser, Exerciser recommend1) {
		super();
		this.exerciser = exerciser;
		this.recommend1 = recommend1;
	}

	public RecommendList(Exerciser exerciser, Exerciser recommend1, Exerciser recommend2, Exerciser recommend3) {
		super();
		this.exerciser = exerciser;
		this.recommend1 = recommend1;
		this.recommend2 = recommend2;
		this.recommend3 = recommend3;
	}
	public RecommendList(Exerciser exerciser, Exerciser recommend1, Exerciser recommend2, Exerciser recommend3,
			int counting) {
		super();
		this.exerciser = exerciser;
		this.recommend1 = recommend1;
		this.recommend2 = recommend2;
		this.recommend3 = recommend3;
		this.counting = counting;
	}
	public Exerciser getExerciser() {
		return exerciser;
	}
	public void setExerciserId(Exerciser exerciser) {
		this.exerciser = exerciser;
	}
	public Exerciser getRecommend1() {
		return recommend1;
	}
	public void setRecommend1(Exerciser recommend1) {
		this.recommend1 = recommend1;
	}
	public Exerciser getRecommend2() {
		return recommend2;
	}
	public void setRecommend2(Exerciser recommend2) {
		this.recommend2 = recommend2;
	}
	public Exerciser getRecommend3() {
		return recommend3;
	}
	public void setRecommend3(Exerciser recommend3) {
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
		return "RecommendList [exerciserId=" + exerciser + ", recommend1=" + recommend1 + ", recommend2=" + recommend2
				+ ", recommend3=" + recommend3 + ", counting=" + counting + "]";
	}
	

	
}
