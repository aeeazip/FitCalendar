package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Exerciser;
import model.RecommendList;

public class RecommendDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언
	private ExerciserDao exerciserDao = new ExerciserDao();


	public RecommendDao() { // 생성자
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용
	}

	/**
	 * exerciser가 추천받은 exerciser의 목록(3명)인 recommendList 조회 //수정 완료
	 */
	public RecommendList displayExerciser(int exerciserId) {
		String query = "SELECT exerciserId, recommId1, recommId2, recommId3, count FROM RecommendList WHERE exerciserId = ?";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);
		RecommendList recommend = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				// 매개변수와 이름이 동일해서 변수 이름 수정
				int exerciser_id = rs.getInt("exerciserId");
				int recomId1 = rs.getInt("recommId1");
				int recomId2 = rs.getInt("recommId2");
				int recomId3 = rs.getInt("recommId3");
				int count = rs.getInt("count");
				System.out.println(recomId1);

				recommend = new RecommendList(exerciser_id, recomId1, recomId2, recomId3, count);
				return recommend;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return recommend;
	}

	/**
	 * exerciser에게 matching 신청을 한 list 조회
	 */
	public RecommendList showGetRecommendList(int exerciserId) {
		String query = "SELECT * FROM recommendlist WHERE recomId1 = ? OR recomId2 = ? OR recomId3 = ?";
		Object[] param = new Object[] { exerciserId, exerciserId, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		RecommendList recommend = null;

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				int sender = rs.getInt("exerciserId");

				int recieverId1 = rs.getInt("recommId1");
				int recieverId2 = rs.getInt("recommId2");
				int recieverId3 = rs.getInt("recommId3");

				if (recieverId1 == exerciserId) {
					recommend = new RecommendList(recieverId1, sender);
				} else if (recieverId2 == exerciserId) {
					recommend = new RecommendList(recieverId2, sender);
				} else {
					recommend = new RecommendList(recieverId3, sender);
				}

			}
			return recommend;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	/**
	 * 추천 정보 입력하면 recommendList table에 추천받는 exerciserId가 추가됨 //내 파트
	 */
	public RecommendList recommendExerciser(int exerciserId){
		usePoint(exerciserId, 30);
		String query = "INSERT INTO recommendlist(exerciserId, recommid1, recommid2, recommid3, count) VALUES (?, ?, ?, ?, 0)";
		int randomRecomm1 =  (int)(Math.random()*10)+1;
		int randomRecomm2 =  (int)(Math.random()*10)+1;
		int randomRecomm3 =  (int)(Math.random()*10)+1;
		
		RecommendList recommendList = null;
		System.out.println(randomRecomm1);
		Object[] param = new Object[] {exerciserId, randomRecomm1, randomRecomm2, randomRecomm3};
		jdbcUtil.setSqlAndParameters(query, param);   // JDBCUtil 에 insert into문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // insert into문 실행
			if(result > 0)
				recommendList = new RecommendList(exerciserId, randomRecomm1, randomRecomm2, randomRecomm3, 0);
			return recommendList; // insert into에 의해 반영된 레코드 수 반환
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return recommendList;   
	}


	/**
	 * 추천 or 매칭 기능 이용 시, exerciser table의 point 차감
	 */
	public int usePoint(int exerciserId, int point) {
		System.out.println("recommendDao");
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
	 * exerciser가 추천받은 RecommendList들 중 마음에 드는 상대에게 Fitmate 요청 보내기 -> requestStatus
	 * table에 행 추가
	 */
	public int requestFitmate(int myExerciserId, int yourExerciserId) {
		String query = "INSERT INTO matchingStatus values (?, ?, 3)";
		Object[] param = new Object[] { myExerciserId, yourExerciserId };
		jdbcUtil.setSqlAndParameters(query, param); // JDBCUtil 에 insert문과 매개 변수 설정

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

	//재추천 메소드
	public int reRecommendExerciser(int exerciserId){
		String query = "UPDATE recommendlist SET count=count+1 " + "WHERE exerciserId = ? ";
		Object[] param = new Object[] {exerciserId};
		jdbcUtil.setSqlAndParameters(query, param);   // JDBCUtil 에 insert into문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return 0;   
	}


	//maxMate 초과 여부 검사
	public int countingMaxMate(int exerciserId) {
		String query = "SELECT COUNT(*) AS c FROM recommendlist WHERE recomId1 = ? OR recomId2 = ? OR recomId3 = ?";
		Object[] param = new Object[] { exerciserId,exerciserId,exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);
		int count = 0;

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				//매개변수와 이름이 동일해서 변수 이름 수정
				count = rs.getInt("c");
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return count;
	}

}