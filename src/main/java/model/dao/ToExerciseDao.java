package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.ToExercise;

public class ToExerciseDao {

	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언

	public ToExerciseDao() { // 생성자
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용

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

	public int addToExercise(int exerciserId, String content) {
		Date date = new Date();
		java.util.Date sqlDate = new java.sql.Date(date.getTime());
		System.out.println(content);
		String query = "insert into toexercise ( itemid, content, checked, exerciserid)\r\n"
				+ "values ( itemseq.nextval, ?, ? , ?)";
		Object[] param = new Object[] { content, 'F', exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			System.out.println(result);
			if (result == 1) {
				return result; // insert 에 의해 반영된 레코드 수 반환
			}
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}

		return 0;
	}

	public int checkToExercise(int exerciserId, int itemId) {
		System.out.println("checking dao");
		String query = "UPDATE toexercise SET checked = ?  WHERE exerciserid = ? and itemId = ?";

		Object[] param = new Object[] { "T", exerciserId, itemId };

		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			System.out.println("result: " + result);
			if (result == 1) {
				return 1; // insert 에 의해 반영된 레코드 수 반환
			}
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}

		return 0;
	}

	public int deleteToExercise(int exerciserId, int itemId) {
		String query = "DELETE FROM toexercise WHERE exerciserid = ? and itemId = ? ";
		Object[] param = new Object[] { exerciserId, itemId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			System.out.println("delete result: " + result);
			if (result == 1) {
				return 1; // insert 에 의해 반영된 레코드 수 반환
			}
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}

		return 0;
	}
	
	public int unCheckToExercise(int exerciserId, int itemId){
		String query = "UPDATE toexercise SET checked = ?  WHERE exerciserid = ? and itemId = ?";
		Object[] param = new Object[] { "F", exerciserId, itemId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			if (result == 1) {
				return 1; // insert 에 의해 반영된 레코드 수 반환
			}
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
