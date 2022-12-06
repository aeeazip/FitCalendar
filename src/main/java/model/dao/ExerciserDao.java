package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Exerciser;

public class ExerciserDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언

	public ExerciserDao() { // 생성자
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용
	}

	// exerciserId로 사용자 조회해서 사용자 정보를 반환하는 메소드
	public Exerciser findExerciser(int exerciserId) {
		Exerciser exerciser = null;
		String query = "select * from exerciser where exerciserId=?";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String nickname = rs.getString("nickname");
				String password = rs.getString("password");
				String explanation = rs.getString("explanation");
				String speciality = rs.getString("speciality");
				String personality = rs.getString("personality");
				String gender = rs.getString("gender");
				int point = rs.getInt("point");
				String useMatchSvc = rs.getString("useMatchSvc");
				int maxMate = rs.getInt("maxMate");
				exerciser = new Exerciser(exerciserId, id, nickname, password, explanation, speciality, personality,
						gender, point, useMatchSvc, maxMate);
			}
			return exerciser;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// 사용자 계정 아이디로 Exerciser 조회해서 사용자 정보를 반환하는 메소드
	public Exerciser findExerciserById(String id) {
		Exerciser exerciser = null;
		String query = "select * from exerciser where id=?";
		Object[] param = new Object[] { id };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				int exerciserId = rs.getInt("exerciserId");
				String nickname = rs.getString("nickname");
				String password = rs.getString("password");
				String explanation = rs.getString("explanation");
				String speciality = rs.getString("speciality");
				String personality = rs.getString("personality");
				String gender = rs.getString("gender");
				int point = rs.getInt("point");
				String useMatchSvc = rs.getString("useMatchSvc");
				int maxMate = rs.getInt("maxMate");

				exerciser = new Exerciser(exerciserId, id, nickname, password, explanation, speciality, personality,
						gender, point, useMatchSvc, maxMate);
			}
			return exerciser;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// 사용자 계정 아이디로 비밀번호 조회하는 메소드
	public String findPassword(String id) {
		String password = null;
		String query = "select password from exerciser where id=?";
		Object[] param = new Object[] { id };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				password = rs.getString("password");
			}
			return password;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// exerciser 계정 생성 -> DB에 exerciser 정보 생성
	public int insertExerciser(String password, String nickname, String explanation, String personality,
			String speciality, String gender, String id) {
		String query = "insert into exerciser (exerciserid, password, nickname, explanation, personality, speciality, gender, id) \r\n"
				+ "values (EXERCISERIDSEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { password, nickname, explanation, personality, speciality, gender, id };
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

	public int updateExerciser(int exerciserId, String nickname, String explanation, String speciality,
			String personality) {
		String query = "update exerciser set nickname=?, explanation=?, speciality=?, personality=? where exerciserid=?";
		Object[] param = new Object[] { nickname, explanation, speciality, personality, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result; // update 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	// profile 조회(exerciserID가 아닌 사용자 id로 조회할 예정)
	public Exerciser findExerciserProfile(String id) {
		Exerciser exerciser = null;
		String query = "select * from exerciser where id=?";
		Object[] param = new Object[] { id };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				int exerciserId = rs.getInt("exerciserId");
				String nickname = rs.getString("nickname");
				String password = rs.getString("password");
				String explanation = rs.getString("explanation");
				String speciality = rs.getString("speciality");
				String personality = rs.getString("personality");
				String gender = rs.getString("gender");
				int point = rs.getInt("point");
				String useMatchSvc = rs.getString("useMatchSvc");
				int maxMate = rs.getInt("maxMate");

				exerciser = new Exerciser(exerciserId, id, nickname, password, explanation, speciality, personality,
						gender, point, useMatchSvc, maxMate);
			}
			return exerciser;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// profile update 수행
	public Exerciser updateExerciserProfile(Exerciser exerciser) {
		Exerciser updateResult = new Exerciser();
		int exerciserId;
		String id;
		String nickname;
		String password;
		String explanation;
		String speciality;
		String personality;
		String gender;
		String useMatchSvc;

		exerciserId = exerciser.getExerciserId();

		id = exerciser.getId();
		nickname = exerciser.getNickname();
		password = exerciser.getPassword();
		explanation = exerciser.getExplanation();
		speciality = exerciser.getSpeciality();
		personality = exerciser.getPersonality();
		gender = exerciser.getGender();
		useMatchSvc = exerciser.getUseMatchSvc();

		String query = " UPDATE exerciser "
				+ "SET id = ?, nickname = ?, password = ?, explanation = ?, speciality = ?, personality = ?, gender = ?, useMatchSvc = ? "
				+ " WHERE exerciserId = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { id, nickname, password, explanation, speciality, personality, gender,
				useMatchSvc, exerciserId };

		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행

			if (result == 1)
				return exerciser; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}

		return null;
	}

	// 계정 삭제(id로 삭제)
	public int deleteExerciser(int deleteId) {
		String query = "DELETE FROM exerciser WHERE exerciserid = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	// 글 작성 시 + 10 - point update 수행
	public int updatePoint(int exerciserId) {
		String query = "update exerciser set point=point+10 where exerciserid=?"; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { exerciserId };

		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result;
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return -1;
	}

	// 출석시 point + 5 - point update 수행
	public int updatePoint2(int exerciserId) {
		String query = "update exerciser set point=point+5 where exerciserid=?"; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { exerciserId };

		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result;
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return -1;
	}

	/**
	 * ranking table에 point누적시키기
	 */
	public int accumulatedPoint(int exerciserId) {
		// String query = "update ranking set point=point+5 where exerciserid=?"; //
		// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { exerciserId };

		//jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result;
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return -1;
	}

	// 주어진 사용자가 오늘 출석 했는지 여부 반환 -> 0이면 출석 안 한 거라 출석 체크, 그 이상은 못하게 해야함
	public int existingAttendance(int exerciserId) throws SQLException {
		String sql = "SELECT count(*) FROM attendance WHERE exerciserid=? and (TO_CHAR(creationdate, 'YYYY/MM/DD') = TO_CHAR(SYSDATE, 'YYYY/MM/DD'))";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { exerciserId }); // JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return 1;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사
	 */
	public boolean existingUser(String inputId) throws SQLException {
		String sql = "SELECT count(*) FROM EXERCISER WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { inputId }); // JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return false;
	}

	/**
	 * 사용자의 정보 검색 //main 출력용
	 */
	public Exerciser showInfo(int exerciserId) {
		String sql = "SELECT exerciserId, nickname, point, explanation, gender FROM EXERCISER WHERE exerciserId=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { exerciserId }); // JDBCUtil에 query문과 매개 변수 설정

		Exerciser exerciser = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			while (rs.next()) {
				exerciser = new Exerciser();
				exerciser.setNickname(rs.getString("nickname"));
				exerciser.setPoint(rs.getInt("point"));
				exerciser.setGender(rs.getString("gender"));

			}
			return exerciser;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 사용자들 랭킹 3위까지 보여주기
	 * 
	 */
	public List<Exerciser> showRanking() {
		String sql = "select a.* from (select * from exerciser order by point desc) a where rownum <=3";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil에 query문과 매개 변수 설정

		List<Exerciser> exerciserList = new ArrayList<Exerciser>();
		Exerciser exerciser = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			while (rs.next()) {
				exerciser = new Exerciser();
				exerciser.setNickname(rs.getString("nickname"));
				exerciser.setPoint(rs.getInt("point"));
				exerciserList.add(exerciser);
			}
			return exerciserList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	// 계정 삭제를 위해서 모든 column 을 삭제할 메소드
	// 계정 삭제(id로 삭제)
	public int deleteAttendance(int deleteId) {
		String query = "DELETE FROM Attendance WHERE exerciserid = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	public int deleteFitmate(int deleteId) {
		String query = "DELETE FROM Fitmate WHERE exerciser1 = ? OR exerciser2 = ?"; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { deleteId, deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	public int deleteInbody(int deleteId) {
		String query = "DELETE FROM Inbody WHERE exerciserid = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	public int deleteMatchingStatus(int deleteId) {
		String query = "DELETE FROM matchingStatus WHERE senderid = ? OR receiverid = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { deleteId, deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	public int deleteMessage(int deleteId) {
		String query = "DELETE FROM Message WHERE senderid = ? OR receiverid = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { deleteId, deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	public int deleteRecommendList(int deleteId) {
		String query = "DELETE FROM RecommendList WHERE exerciserid = ? OR recommid1 = ? OR recommid2 = ? OR recommid3 = ? "; // JDBCUtil
																																// 에																															// 설정
		Object[] param = new Object[] { deleteId, deleteId, deleteId, deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	public int deleteRecord(int deleteId) {
		String query = "DELETE FROM Record WHERE exerciserid = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

	public int deleteToExercise(int deleteId) {
		String query = "DELETE FROM ToExercise WHERE exerciserid = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { deleteId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result; // delete 에 의해 반영된 레코드 수 반환
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