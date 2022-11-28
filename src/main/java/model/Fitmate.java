package model;

public class Fitmate {
	private Exerciser exerciser1;
	private Exerciser exerciser2;
	
	public Exerciser getExerciser1() {
		return exerciser1;
	}
	public void setExerciser1(Exerciser exerciser1) {
		this.exerciser1 = exerciser1;
	}
	public Exerciser getExerciser2() {
		return exerciser2;
	}
	public void setExerciser2(Exerciser exerciser2) {
		this.exerciser2 = exerciser2;
	}
	
	public Fitmate(Exerciser exerciser1, Exerciser exerciser2) {
		super();
		this.exerciser1 = exerciser1;
		this.exerciser2 = exerciser2;
	}
	public Fitmate(Exerciser exerciser1) {
		super();
		this.exerciser1 = exerciser1;
	}
	
	@Override
	public String toString() {
		return "Fitmate [exerciser1=" + exerciser1 + ", exerciser2=" + exerciser2 + "]";
	}
}
