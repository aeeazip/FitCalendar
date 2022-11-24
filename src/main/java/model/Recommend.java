package model;


public class Recommend {
	private int height;
	private int weight;
	private int percentBodyFat;
	private int category;
	//다 radio 버튼의 value 값으로 저장되니까 int로!
	
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
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	public Recommend(int height, int weight, int percentBodyFat, int category) {
		super();
		this.height = height;
		this.weight = weight;
		this.percentBodyFat = percentBodyFat;
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Recommend [height=" + height + ", weight=" + weight + ", percentBodyFat=" + percentBodyFat
				+ ", category=" + category + "]";
	}
	
	
}
