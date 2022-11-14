package main.java.Dao;

import java.sql.ResultSet;

import main.java.Utils.JDBCUtil;


public class ExerciserDao {
	private JDBCUtil jdbcUtil = null;	// JDBCUtil 참조 변수 선언

	public ExerciserDao() {	// 생성자 
		jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성 및 활용
	}
	
	public void findExerciser(int exerciserId) {
		String nickname = null;
		String query = "select nickname from exerciser where exerciserId=?";
		Object[] param = new Object[] {exerciserId};
		jdbcUtil.setSqlAndParameters(query, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			
			while(rs.next()) {
				nickname = rs.getString("nickname");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		System.out.println(nickname);
	}
}
