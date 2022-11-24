package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.CompareInbody;
import model.CompareStatic;
import model.ToExercise;

public class StaticDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언

	public StaticDao() { // 생성자
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

	public ArrayList<ToExercise> findToExercise(int exerciserId) {
		ArrayList<ToExercise> toExerciseList = new ArrayList<ToExercise>();
		ToExercise list;

		String query = "select * from toexercise where exerciserId=?";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				int itemid = rs.getInt("itemid");
				String creationDate = rs.getString("creationdate");
				String content = rs.getString("content");
				String checked = rs.getString("checked");

				list = new ToExercise(itemid, creationDate, content, checked, exerciserId);
				toExerciseList.add(list);
			}
			return toExerciseList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public ArrayList<ToExercise> addToExercise(int exerciserId, String content) {
		Date date = new Date();
		java.util.Date sqlDate = new java.sql.Date(date.getTime());

		String query = "insert into toexercise  (creationdate, content, checked, exerciserid)\r\n"
				+ "values (?, ?, F , ?)";
		Object[] param = new Object[] { date, content, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			if (result == 1) {
				return findToExercise(exerciserId); // insert 에 의해 반영된 레코드 수 반환
			}
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}

		return null;
	}

	public ArrayList<ToExercise> checkToExercise(int exerciserId, int itemId) {
		String query = "UPDATE toexercise " + "SET checked = ? " + " WHERE exerciserid = ? and itemdId = ? ";

		Object[] param = new Object[] { "T", exerciserId, itemId };

		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			if (result == 1) {
				return findToExercise(exerciserId); // insert 에 의해 반영된 레코드 수 반환
			}
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}

		return null;
	}

	public ArrayList<ToExercise> deleteToExercise(int exerciserId, int itemId) {
		String query = "DELETE FROM toexercise WHERE exerciserid = ? and itemdId = ? ";
		Object[] param = new Object[] { exerciserId, itemId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			if (result == 1) {
				return findToExercise(exerciserId); // insert 에 의해 반영된 레코드 수 반환
			}
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}

		return null;
	}

	public CompareStatic calculateStatic(int exerciserId) {
		ArrayList<CompareInbody> list = new ArrayList<CompareInbody>();
		CompareInbody c_inbody;
		CompareStatic c_static;
		int weeklyCount = 0;
		int monthlyCount = 0;

		String query = "SELECT percentbodyfat, skeletalmm, visceralfat \r\n"
				+ "FROM (SELECT percentbodyfat, skeletalmm, visceralfat, measuredate FROM inbody WHERE exerciserid = ? ORDER BY measuredate ASC)\r\n"
				+ "WHERE rownum <=2;";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				int bodyfat = rs.getInt("percentbodyfat");
				int skeletalmm = rs.getInt("skeletalmm");
				int visceralfat = rs.getInt("visceralfat");

				c_inbody = new CompareInbody(bodyfat, skeletalmm, visceralfat);
				list.add(c_inbody);

			}

			String query2 = "SELECT count(*) AS monthlyCount \r\n" + "FROM ATTENDANCE\r\n"
					+ "WHERE creationdate >= sysdate- 30 AND exerciserid = ?;";

			Object[] param2 = new Object[] { exerciserId };
			jdbcUtil.setSqlAndParameters(query2, param2);

			ResultSet rs2 = jdbcUtil.executeQuery();
			if (rs2.next()) {
				monthlyCount = rs2.getInt("monthlyCount");
			}

			String query3 = "SELECT count(*) AS weeklyCount \r\n" + "FROM ATTENDANCE\r\n"
					+ "WHERE creationdate >= sysdate- 7 AND exerciserid = ?;";

			Object[] param3 = new Object[] { exerciserId };
			jdbcUtil.setSqlAndParameters(query2, param2);

			ResultSet rs3 = jdbcUtil.executeQuery();
			if (rs2.next()) {
				weeklyCount = rs3.getInt("WeeklyCount");
			}

			int c_fat = list.get(1).getPercentFat() - list.get(0).getPercentFat();
			int c_muscle = list.get(1).getMuscle() - list.get(0).getMuscle();
			int c_vfat = list.get(1).getVisceralFat() - list.get(0).getVisceralFat();

			c_static = new CompareStatic(weeklyCount, monthlyCount, c_fat, c_muscle, c_vfat);

			return c_static;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;

	}
}
