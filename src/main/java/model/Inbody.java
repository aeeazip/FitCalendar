package model;

public class Inbody {
	private int inbodyId;
	private int height;
	private int weight;
	private int percentBodyFat;
	private int skeletalMM;
	private int visceralFat;
	private String measureDate;
	private int exerciserId;

	public int getInbodyId() {
		return inbodyId;
	}

	public void setInbodyId(int inbodyId) {
		this.inbodyId = inbodyId;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPercentBodyFat() {
		return percentBodyFat;
	}

	public void setPercentBodyFat(int percentBodyFat) {
		this.percentBodyFat = percentBodyFat;
	}

	public int getSkeletalMM() {
		return skeletalMM;
	}

	public void setSkeletalMM(int skeletalMM) {
		this.skeletalMM = skeletalMM;
	}

	public int getVisceralFat() {
		return visceralFat;
	}

	public void setVisceralFat(int visceralFat) {
		this.visceralFat = visceralFat;
	}

	public String getMeasureDate() {
		return measureDate;
	}

	public void setMeasureDate(String measureDate) {
		this.measureDate = measureDate;
	}

	public int getExerciserId() {
		return exerciserId;
	}

	public void setExerciserId(int exerciserId) {
		this.exerciserId = exerciserId;
	}

	public Inbody(int inbodyId, int height, int weight, int percentBodyFat, int skeletalMM, int visceralFat,
			String measureDate, int exerciserId) {
		super();
		this.inbodyId = inbodyId;
		this.height = height;
		this.weight = weight;
		this.percentBodyFat = percentBodyFat;
		this.skeletalMM = skeletalMM;
		this.visceralFat = visceralFat;
		this.measureDate = measureDate;
		this.exerciserId = exerciserId;
	}

	// register 시 사용할 생성자
	public Inbody(int height, int weight, int percentBodyFat, int skeletalMM, int visceralFat, String measureDate,
			int exerciserId) {
		super();
		this.height = height;
		this.weight = weight;
		this.percentBodyFat = percentBodyFat;
		this.skeletalMM = skeletalMM;
		this.visceralFat = visceralFat;
		this.measureDate = measureDate;
		this.exerciserId = exerciserId;
	}

	public Inbody() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Inbody [inbodyId=" + inbodyId + ", height=" + height + ", weight=" + weight + ", percentBodyFat="
				+ percentBodyFat + ", skeletalMM=" + skeletalMM + ", visceralFat=" + visceralFat + ", measureDate="
				+ measureDate + ", exerciserId=" + exerciserId + "]";
	}

}