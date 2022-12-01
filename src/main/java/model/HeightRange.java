package model;

public class HeightRange {
	private int heightId;
	private int height1;
	private int height2;
	public HeightRange(int heightId, int height1, int height2) {
		super();
		this.heightId = heightId;
		this.height1 = height1;
		this.height2 = height2;
	}
	public int getHeightId() {
		return heightId;
	}
	public void setHeightId(int heightId) {
		this.heightId = heightId;
	}
	public int getHeight1() {
		return height1;
	}
	public void setHeight1(int height1) {
		this.height1 = height1;
	}
	public int getHeight2() {
		return height2;
	}
	public void setHeight2(int height2) {
		this.height2 = height2;
	}
	@Override
	public String toString() {
		return "heightRange [heightId=" + heightId + ", height1=" + height1 + ", height2=" + height2 + "]";
	}

	
}
