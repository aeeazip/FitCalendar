package main.java.Matching.Dto;

public class MatchingStatus {
	private int senderId;
	private int receiverId;
	private int status;
	
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public MatchingStatus(int senderId, int receiverId, int status) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.status = status;
	}
	
	public MatchingStatus() {
		super();
	}
	
	@Override
	public String toString() {
		return "MatchingStatus [senderId=" + senderId + ", receiverId=" + receiverId + ", status=" + status + "]";
	}
}
