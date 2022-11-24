package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.RecommendList;


public class RecommendDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언

	public RecommendDao() { // 생성자
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용
	}
	
	/**
	 * exerciser가 추천받은 exerciser의 목록(3명)인 recommendList 조회 
	 */
	public RecommendList displayExerciser(int exerciserId){
		String query = "SELECT exerciserId, recomId1, recomId2, recomId3 FROM RecommendList WHERE exerciserId = ?";
		Object[] param = new Object[] {exerciserId};
		jdbcUtil.setSqlAndParameters(query, param);
		
		RecommendList recommend = null;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				recommend = new RecommendList(rs.getInt("recomId1"),rs.getInt("recomId2"),rs.getInt("recomId3"));	}
			return recommend;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	/**
	 * exerciser에게 matching 신청을 한 list 조회
	 */
	public List<RecommendList> showGetRecommendList(int exerciserId){
		String query = "SELECT * FROM recommendlist WHERE recomId1 = ? OR recomId2 = ? OR recomId3 = ?";
		Object[] param = new Object[] { exerciserId,exerciserId,exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);
		
		RecommendList recommend = null;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<RecommendList> getRecommList = new ArrayList<RecommendList>();
			while (rs.next()) {
				recommend = new RecommendList(
						rs.getInt("exerciserId"), rs.getInt("recomId1"),rs.getInt("recomId2"),rs.getInt("recomId3"));	
				getRecommList.add(recommend);
			}
			return getRecommList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	/**
	 * 추천 정보 입력하면 recommendList table에 추천받는 exerciserId가 추가됨.
	 */
	public int recommendExerciser(int exerciserId){
		String query = "INSERT INTO recommendlist(exerciserId) VALUES (?)";
		Object[] param = new Object[] {exerciserId};
		jdbcUtil.setSqlAndParameters(query, param);	// JDBCUtil 에 insert into문과 매개 변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate(); // insert into문 실행
			return result; // insert into에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;	
	}
	/**
	 * 추천 or 매칭 기능 이용 시, exerciser table의 point 차감
	 */
	public int usePoint(int exerciserId, int point){
		String query = "UPDATE exerciser SET point = NVL(point, 0) - ? WHERE exerciserId = ?";
		Object[] param = new Object[] { point, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // UPDATE 문 실행
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
	/**
	 * exerciser가 추천받은 RecommendList들 중 마음에 드는 상대에게 Fitmate 요청 보내기 -> requestStatus table에 행 추가
	 */
	public int requestFitmate(int myExerciserId, int yourExerciserId) {
		String query = "INSERT INTO RequestStatus values (?, ?, 0)";
		Object[] param = new Object[] {myExerciserId, yourExerciserId};
		jdbcUtil.setSqlAndParameters(query, param);	// JDBCUtil 에 insert문과 매개 변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate(); // insert into문 실행
			return result; // insert into에 의해 반영된 레코드 수 반환
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