package model;

public class WeightRange {
	private int weightId;
	private int weight1;
	private int weight2;
	
	public WeightRange(int weightId, int weight1, int weight2) {
		super();
		this.weightId = weightId;
		this.weight1 = weight1;
		this.weight2 = weight2;
	}

	public int getWeightId() {
		return weightId;
	}

	public void setWeightId(int weightId) {
		this.weightId = weightId;
	}

	public int getWeight1() {
		return weight1;
	}

	public void setWeight1(int weight1) {
		this.weight1 = weight1;
	}

	public int getWeight2() {
		return weight2;
	}

	public void setWeight2(int weight2) {
		this.weight2 = weight2;
	}

	@Override
	public String toString() {
		return "weightRange [weightId=" + weightId + ", weight1=" + weight1 + ", weight2=" + weight2 + "]";
	}
	
	

}
