package model;

public class CompareStatic {
	int weeklyCount;
	int MonthlyCount;

	int ComparePercentFat;
	int CompareMuscle;
	int CompareVisceralFat;

	public CompareStatic() {
		super();
	}

	public CompareStatic(int weeklyCount, int monthlyCount, int comparePercentFat, int compareMuscle,
			int compareVisceralFat) {
		super();
		this.weeklyCount = weeklyCount;
		MonthlyCount = monthlyCount;
		ComparePercentFat = comparePercentFat;
		CompareMuscle = compareMuscle;
		CompareVisceralFat = compareVisceralFat;
	}

	public CompareStatic(int weeklyCount, int monthlyCount) {
		super();
		this.weeklyCount = weeklyCount;
		MonthlyCount = monthlyCount;
	}

	public CompareStatic(int comparePercentFat, int compareMuscle, int compareVisceralFat) {
		super();
		ComparePercentFat = comparePercentFat;
		CompareMuscle = compareMuscle;
		CompareVisceralFat = compareVisceralFat;
	}

	public int getWeeklyCount() {
		return weeklyCount;
	}

	public void setWeeklyCount(int weeklyCount) {
		this.weeklyCount = weeklyCount;
	}

	public int getMonthlyCount() {
		return MonthlyCount;
	}

	public void setMonthlyCount(int monthlyCount) {
		MonthlyCount = monthlyCount;
	}

	public int getComparePercentFat() {
		return ComparePercentFat;
	}

	public void setComparePercentFat(int comparePercentFat) {
		ComparePercentFat = comparePercentFat;
	}

	public int getCompareMuscle() {
		return CompareMuscle;
	}

	public void setCompareMuscle(int compareMuscle) {
		CompareMuscle = compareMuscle;
	}

	public int getCompareVisceralFat() {
		return CompareVisceralFat;
	}

	public void setCompareVisceralFat(int compareVisceralFat) {
		CompareVisceralFat = compareVisceralFat;
	}

	@Override
	public String toString() {
		return "Static [weeklyCount=" + weeklyCount + ", MonthlyCount=" + MonthlyCount + ", ComparePercentFat="
				+ ComparePercentFat + ", CompareMuscle=" + CompareMuscle + ", CompareVisceralFat=" + CompareVisceralFat
				+ "]";
	}

}
