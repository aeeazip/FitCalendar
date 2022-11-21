package model;

public class CompareInbody {
	int PercentFat;
	int Muscle;
	int VisceralFat;

	public CompareInbody() {
		super();
	}

	public CompareInbody(int percentFat, int muscle, int visceralFat) {
		super();
		PercentFat = percentFat;
		Muscle = muscle;
		VisceralFat = visceralFat;
	}

	public int getPercentFat() {
		return PercentFat;
	}

	public void setPercentFat(int percentFat) {
		PercentFat = percentFat;
	}

	public int getMuscle() {
		return Muscle;
	}

	public void setMuscle(int muscle) {
		Muscle = muscle;
	}

	public int getVisceralFat() {
		return VisceralFat;
	}

	public void setVisceralFat(int visceralFat) {
		VisceralFat = visceralFat;
	}

	@Override
	public String toString() {
		return "CompareInbody [PercentFat=" + PercentFat + ", Muscle=" + Muscle + ", VisceralFat=" + VisceralFat + "]";
	}

}
