package model;

public class Ranking {
	private int accumed_point;
	private int sum_record;
	private int ranking;
	private Exerciser exerciser;
	
	public int getAccumed_point() {
		return accumed_point;
	}
	public void setAccumed_point(int accumed_point) {
		this.accumed_point = accumed_point;
	}
	public int getSum_record() {
		return sum_record;
	}
	public void setSum_record(int sum_record) {
		this.sum_record = sum_record;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public Exerciser getExerciser() {
		return exerciser;
	}
	public void setExerciser(Exerciser exerciser) {
		this.exerciser = exerciser;
	}
	public Ranking(int accumed_point, int sum_record, int ranking, Exerciser exerciser) {
		super();
		this.accumed_point = accumed_point;
		this.sum_record = sum_record;
		this.ranking = ranking;
		this.exerciser = exerciser;
	}
	
	public Ranking() {
		super();
	}
	
	@Override
	public String toString() {
		return "Ranking [accumed_point=" + accumed_point + ", sum_record=" + sum_record + ", ranking=" + ranking
				+ ", exerciser=" + exerciser + "]";
	}
	
	
}
