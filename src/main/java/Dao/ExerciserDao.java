package main.java.Dao;

import java.sql.ResultSet;

import main.java.Dto.Exerciser;
import main.java.Utils.JDBCUtil;


public class ExerciserDao {
	private JDBCUtil jdbcUtil = null;	// JDBCUtil 참조 변수 선언

	public ExerciserDao() {	// 생성자 
		jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성 및 활용
	}

	// exerciserId로 사용자 조회해서 사용자 정보를 반환하는 메소드
	public Exerciser findExerciser(int exerciserId) {
		Exerciser exerciser = null;
		String query = "select * from exerciser where exerciserId=?";
		Object[] param = new Object[] {exerciserId};
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while(rs.next()) {
				String id = rs.getString("id");			
				String nickname = rs.getString("nickname");	
				String password = rs.getString("password");	
				String explanation = rs.getString("explanation");	
				String speciality = rs.getString("speciality");	
				String personality = rs.getString("personality");	
				String gender = rs.getString("gender");		
				int point = rs.getInt("point");			
				int ranking = rs.getInt("ranking");		
				int useMatchSvc = rs.getInt("useMatchSvc");

				exerciser = new Exerciser(exerciserId, id, nickname, password, explanation, speciality, personality, gender, point, ranking, useMatchSvc);
			}
			return exerciser;
		} catch(Exception e) {
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
			Object[] param = new Object[] {id};
			jdbcUtil.setSqlAndParameters(query, param);

			try {
				ResultSet rs = jdbcUtil.executeQuery();

				while(rs.next()) {
					int exerciserId = rs.getInt("exerciserId");
					String nickname = rs.getString("nickname");	
					String password = rs.getString("password");	
					String explanation = rs.getString("explanation");	
					String speciality = rs.getString("speciality");	
					String personality = rs.getString("personality");	
					String gender = rs.getString("gender");		
					int point = rs.getInt("point");			
					int ranking = rs.getInt("ranking");		
					int useMatchSvc = rs.getInt("useMatchSvc");

					exerciser = new Exerciser(exerciserId, id, nickname, password, explanation, speciality, personality, gender, point, ranking, useMatchSvc);
				}
				return exerciser;
			} catch(Exception e) {
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
		Object[] param = new Object[] {id};
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while(rs.next()) {				
				password = rs.getString("password");	
			}
			return password;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}


	//사용자 계정 password를 전달받아 해당 password의 사용자 정보를 삭제하는 메소드
	public int deleteExerciser(String password) {
		String query = "DELETE FROM exerciser WHERE password = ?"; // JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { password };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			return result;							// delete 에 의해 반영된 레코드 수 반환
		} catch(Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}
}
