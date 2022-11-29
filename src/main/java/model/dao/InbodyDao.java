package model.dao;

import java.sql.ResultSet;

import model.Inbody;

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

	public Inbody findInbody(int exerciserId) {
		Inbody inbody = null;
		String query = "SELECT * FROM (SELECT * FROM inbody WHERE exerciserid = ? ORDER BY inbodyid DESC)WHERE rownum <=1";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);
		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				int percentbodyfat = rs.getInt("percentbodyfat");
				int skeletalmm = rs.getInt("skeletalmm");
				int visceralfat = rs.getInt("visceralfat");
				String measuredate = rs.getString("measuredate");

				inbody = new Inbody(height, weight, percentbodyfat, skeletalmm, visceralfat, measuredate, exerciserId);
			}
			return inbody;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// exerciserId로 최근 inbody 정보 2개 제외하고 지우기
//	public int deleteInbody(int exerciserId) {
//
//	}

	// Inbody 수정 안 하기로 했나 인바디 정보 업뎃 어케 하기로 했떠라

}