package main.java.Matching.Dto;

public class RecommendList {
	int exerciserId;
	int recomId1;
	int recomId2;
	int recomId3;
	
	public int getExerciserId() {
		return exerciserId;
	}
	public void setExerciserId(int exerciserId) {
		this.exerciserId = exerciserId;
	}
	public int getRecomId1() {
		return recomId1;
	}
	public void setRecomId1(int recomId1) {
		this.recomId1 = recomId1;
	}
	public int getRecomId2() {
		return recomId2;
	}
	public void setRecomId2(int recomId2) {
		this.recomId2 = recomId2;
	}
	public int getRecomId3() {
		return recomId3;
	}
	public void setRecomId3(int recomId3) {
		this.recomId3 = recomId3;
	}
	
	public RecommendList() {
		super();
	}
	
	public RecommendList(int exerciserId, int recomId1, int recomId2, int recomId3) {
		super();
		this.exerciserId = exerciserId;
		this.recomId1 = recomId1;
		this.recomId2 = recomId2;
		this.recomId3 = recomId3;
	}
	
	public RecommendList(int recomId1, int recomId2, int recomId3) {
		super();
		this.recomId1 = recomId1;
		this.recomId2 = recomId2;
		this.recomId3 = recomId3;
	}
	
	@Override
	public String toString() {
		return "Recommend [exerciserId=" + exerciserId + ", recomId1=" + recomId1 + ", recomId2=" + recomId2
				+ ", recomId3=" + recomId3 + "]";
	}
	
}
