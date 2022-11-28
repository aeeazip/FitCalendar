package model;

public class Message {
	int msgId;
	String content;
	int senderId;
	int receiverId;
	String sendDate;
	
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	public Message(int msgId, String content, int senderId, int receiverId, String sendDate) {
		super();
		this.msgId = msgId;
		this.content = content;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.sendDate = sendDate;
	}
	
	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", content=" + content + ", senderId=" + senderId + ", receiverId="
				+ receiverId + ", sendDate=" + sendDate + "]";
	}	
}
