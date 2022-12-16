package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Message;
import model.Record;

public class FitmateDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언

	public FitmateDao() { // 생성자
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용
	}
	
	public List<Message> getSendMessage(int senderId, int receiverId){ // sender에 내 id + receiver에 상대 fitmate id
		String query = "select * from message where senderid=? and receiverid=? order by msgid desc";
		Object[] param = new Object[] {senderId, receiverId};
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			List<Message> list = new ArrayList<Message>();
			while (rs.next()) {
				int msgId = rs.getInt("msgId");
				String content = rs.getString("content");
				int sId = rs.getInt("senderId");
				int rId = rs.getInt("receiverId");
				String sendDate = rs.getString("sendDate");

				Message message = new Message(msgId, content, sId, rId, sendDate);
				list.add(message);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public List<Message> getReceiveMessage(int senderId, int receiverId){ // sender에 상대 fitmate + receiver에 내 id
		String query = "select * from message where senderid=? and receiverid=? order by msgid desc";
		Object[] param = new Object[] {senderId, receiverId};
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			List<Message> list = new ArrayList<Message>();
			while (rs.next()) {
				int msgId = rs.getInt("msgId");
				String content = rs.getString("content");
				int sId = rs.getInt("senderId");
				int rId = rs.getInt("receiverId");
				String sendDate = rs.getString("sendDate");

				Message message = new Message(msgId, content, sId, rId, sendDate);
				list.add(message);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	public int sendMessage(int senderId, int receiverId, String content) { // sender ->  receiver로 메시지 전송
		String query = "insert into message (msgid, content, senderid, receiverid) VALUES (MSGIDSEQ.nextval, ?, ?, ?)";
		
		Object[] param = new Object[] { content, senderId, receiverId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			return result; // insert 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}
}
