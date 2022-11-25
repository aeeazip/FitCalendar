package model;

public class MatchingStatus {
	
	private Exerciser sender;
	private Exerciser receiver;
	private int status;
	
	public Exerciser getSender() {
		return sender;
	}

	public void setSender(Exerciser sender) {
		this.sender = sender;
	}


	public Exerciser getReceiver() {
		return receiver;
	}


	public void setReceiver(Exerciser receiver) {
		this.receiver = receiver;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public MatchingStatus() {
		super();
	}

	public MatchingStatus(Exerciser sender, Exerciser receiver, int status) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.status = status;
	}

	@Override
	public String toString() {
		return "MatchingStatus [sender=" + sender + ", receiver=" + receiver + ", status=" + status + "]";
	}
	
}
