package model;

public class PercentBodyFatRange {
	private int percentBodyFatId;
	private int percentBodyFat1;
	private int percentBodyFat2;
	public PercentBodyFatRange(int percentBodyFatId, int percentBodyFat1, int percentBodyFat2) {
		super();
		this.percentBodyFatId = percentBodyFatId;
		this.percentBodyFat1 = percentBodyFat1;
		this.percentBodyFat2 = percentBodyFat2;
	}
	public int getPercentBodyFatId() {
		return percentBodyFatId;
	}
	public void setPercentBodyFatId(int percentBodyFatId) {
		this.percentBodyFatId = percentBodyFatId;
	}
	public int getPercentBodyFat1() {
		return percentBodyFat1;
	}
	public void setPercentBodyFat1(int percentBodyFat1) {
		this.percentBodyFat1 = percentBodyFat1;
	}
	public int getPercentBodyFat2() {
		return percentBodyFat2;
	}
	public void setPercentBodyFat2(int percentBodyFat2) {
		this.percentBodyFat2 = percentBodyFat2;
	}
	@Override
	public String toString() {
		return "percentBodyFatRange [percentBodyFatId=" + percentBodyFatId + ", percentBodyFat1=" + percentBodyFat1
				+ ", percentBodyFat2=" + percentBodyFat2 + "]";
	}
	
	
}
