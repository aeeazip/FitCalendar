package model;

public class ToExercise {
	int itemId;
	String creationDate;
	String content;
	String checked;
	int exerciserId;

	public ToExercise(int itemId, String creationDate, String content, String checked, int exerciserId) {
		super();
		this.itemId = itemId;
		this.creationDate = creationDate;
		this.content = content;
		this.checked = checked;
		this.exerciserId = exerciserId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public int getExerciserId() {
		return exerciserId;
	}

	public void setExerciserId(int exerciserId) {
		this.exerciserId = exerciserId;
	}

	@Override
	public String toString() {
		return "ToExercise [itemId=" + itemId + ", creationDate=" + creationDate + ", content=" + content + ", checked="
				+ checked + ", exerciserId=" + exerciserId + "]";
	}

}
