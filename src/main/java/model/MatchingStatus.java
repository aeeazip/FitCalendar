package model;

public class MatchingStatus {
	
	private int sender;
	private int receiver;
	private String receiverNickName;
	private int status;
	
	public MatchingStatus(int sender, int receiver, int status) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
	}

	public MatchingStatus(int sender, int receiver, String receiverNickName, int status) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.receiverNickName = receiverNickName;
		this.status = status;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getReceiverNickName() {
		return receiverNickName;
	}

	public void setReceiverNickName(String receiverNickName) {
		this.receiverNickName = receiverNickName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MatchingStatus [sender=" + sender + ", receiver=" + receiver + ", receiverNickName=" + receiverNickName
				+ ", status=" + status + "]";
	}
	
}
