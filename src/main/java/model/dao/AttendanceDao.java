package model.dao;

import java.util.Date;

public class AttendanceDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언

	public AttendanceDao() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용
	}

	public int checkAttendance(int exerciserId) {
		Date date = new Date();
		java.util.Date sqlDate = new java.sql.Date(date.getTime());
		String query = "insert into attendance (creationdate, exerciserid)\r\n" + "values (?, ?)";
		Object[] param = new Object[] { sqlDate, exerciserId };
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
