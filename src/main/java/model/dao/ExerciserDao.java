package model.dao;

import java.sql.ResultSet;

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
				int ranking = rs.getInt("ranking");
				String useMatchSvc = rs.getString("useMatchSvc");
				int maxMate = rs.getInt("maxMate");
				exerciser = new Exerciser(exerciserId, id, nickname, password, explanation, speciality, personality,
						gender, point, ranking, useMatchSvc, maxMate);
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
				int ranking = rs.getInt("ranking");
				String useMatchSvc = rs.getString("useMatchSvc");
				int maxMate = rs.getInt("maxMate");

				exerciser = new Exerciser(exerciserId, id, nickname, password, explanation, speciality, personality,
						gender, point, ranking, useMatchSvc, maxMate);
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

	public int updateExerciser(int exerciserId, String id, String nickname, String password, String explanation,
			String speciality, String personality, String gender, String useMatchSvc, int maxMate) {
		String query = " UPDATE exerciser "
				+ "SET id = ?, nickname = ?, password = ?, explanation = ?, speciality = ?, personality = ?, gender = ?, useMatchSvc = ? , maxMate = ? "
				+ " WHERE exerciserId = ? "; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { id, nickname, password, explanation, speciality, personality, gender,
				useMatchSvc, maxMate, exerciserId };
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
				int ranking = rs.getInt("ranking");
				String useMatchSvc = rs.getString("useMatchSvc");
				int maxMate = rs.getInt("maxMate");

				exerciser = new Exerciser(exerciserId, id, nickname, password, explanation, speciality, personality,
						gender, point, ranking, useMatchSvc, maxMate);
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
	public int deleteExerciser(String deleteId) {
		String query = "DELETE FROM exerciser WHERE id = ?"; // JDBCUtil 에 query 문 설정
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

	// point update 수행
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
}