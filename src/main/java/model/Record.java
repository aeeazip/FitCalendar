package model;

public class Record {
	int recordId;
	String title;
	String creationDate;
	int totalTime;
	int category;
	String routine;
	String diet;
	String photo;
	int shareOption;
	int exerciserId;

	public Record(int recordId, String title, String creationDate, int totalTime, int category, String routine,
			String diet, String photo, int shareOption, int exerciserId) {
		super();
		this.recordId = recordId;
		this.title = title;
		this.creationDate = creationDate;
		this.totalTime = totalTime;
		this.category = category;
		this.routine = routine;
		this.diet = diet;
		this.photo = photo;
		this.shareOption = shareOption;
		this.exerciserId = exerciserId;
	}

	public Record(String title, String creationDate, int totalTime, int category, String routine, String diet,
			String photo, int shareOption, int exerciserId) {
		super();
		this.title = title;
		this.creationDate = creationDate;
		this.totalTime = totalTime;
		this.category = category;
		this.routine = routine;
		this.diet = diet;
		this.photo = photo;
		this.shareOption = shareOption;
		this.exerciserId = exerciserId;
	}

	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getRoutine() {
		return routine;
	}

	public void setRoutine(String routine) {
		this.routine = routine;
	}

	public String getDiet() {
		return diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getShareOption() {
		return shareOption;
	}

	public void setShareOption(int shareOption) {
		this.shareOption = shareOption;
	}

	public int getExerciserId() {
		return exerciserId;
	}

	public void setExerciserId(int exerciserId) {
		this.exerciserId = exerciserId;
	}

	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", title=" + title + ", creationDate=" + creationDate + ", totalTime="
				+ totalTime + ", category=" + category + ", routine=" + routine + ", diet=" + diet + ", photo=" + photo
				+ ", shareOption=" + shareOption + ", exerciserId=" + exerciserId + "]";
	}

}
