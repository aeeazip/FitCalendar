package main.java.Inbody.Dao;

import main.java.Utils.JDBCUtil;

public class InbodyDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언

	public InbodyDao() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용
	}

	// 인바디 정보 추가
	public int insertInbody(int height, int weight, int percentBodyFat, int skeletalMM, int visceralFat,
			String measureDate, int exerciserId) {
		String query = "insert into inbody values(INBODYIDSEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { height, weight, percentBodyFat, skeletalMM, visceralFat, measureDate,
				exerciserId };
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

	// exerciserId로 최근 inbody 정보 2개 제외하고 지우기
//	public int deleteInbody(int exerciserId) {
//
//	}

	// Inbody 수정 안 하기로 했나 인바디 정보 업뎃 어케 하기로 했떠라

}
