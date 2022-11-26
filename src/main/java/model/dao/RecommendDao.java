package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Exerciser;
import model.RecommendList;

public class RecommendDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언
	private ExerciserDao exerciserDao;


	public RecommendDao() { // 생성자
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용
	}

	/**
	 * exerciser가 추천받은 exerciser의 목록(3명)인 recommendList 조회 //수정 완료
	 */
	public RecommendList displayExerciser(int exerciserId) {
		String query = "SELECT exerciserId, recomId1, recomId2, recomId3 FROM RecommendList WHERE exerciserId = ?";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		RecommendList recommend = null;

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				// 매개변수와 이름이 동일해서 변수 이름 수정
				int exerciser_id = rs.getInt("exerciserId");
				Exerciser recom1 = exerciserDao.findExerciser(rs.getInt("recomId1"));
				Exerciser recom2 = exerciserDao.findExerciser(rs.getInt("recomId2"));
				Exerciser recom3 = exerciserDao.findExerciser(rs.getInt("recomId3"));
				recommend = new RecommendList(exerciser_id, recom1, recom2, recom3);
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
	public List<RecommendList> showGetRecommendList(int exerciserId) {
		String query = "SELECT * FROM recommendlist WHERE recomId1 = ? OR recomId2 = ? OR recomId3 = ?";
		Object[] param = new Object[] { exerciserId, exerciserId, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		RecommendList recommend = null;

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<RecommendList> getRecommList = new ArrayList<RecommendList>();
			while (rs.next()) {
				int recomm_id = rs.getInt("exerciserId");
				Exerciser wantRecomm = exerciserDao.findExerciser(recomm_id);
				Exerciser exerciser1 = exerciserDao.findExerciser(rs.getInt("recomId1"));
				Exerciser exerciser2 = exerciserDao.findExerciser(rs.getInt("recomId2"));
				Exerciser exerciser3 = exerciserDao.findExerciser(rs.getInt("recomId3"));
				if (exerciser1 != null) {
					recommend = new RecommendList(exerciser1.getExerciserId(), wantRecomm);
				} else if (exerciser2 != null) {
					recommend = new RecommendList(exerciser2.getExerciserId(), wantRecomm);
				} else {
					recommend = new RecommendList(exerciser3.getExerciserId(), wantRecomm);
				}

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
	 * 추천 정보 입력하면 recommendList table에 추천받는 exerciserId가 추가됨 //내 파트
	 */
	public int recommendExerciser(int exerciserId){
		String query = "INSERT INTO recommendlist(exerciserId) VALUES (?, ?, ?, ?, ?)";
		int randomRecomm1 =  (int)(Math.random()*20);
		int randomRecomm2 =  (int)(Math.random()*20);
		int randomRecomm3 =  (int)(Math.random()*20);

		Exerciser recom1 = exerciserDao.findExerciser(randomRecomm1);
		int count = countingMaxMate(randomRecomm1);
		//maxMate 초과 여부 검사
		while(count <= recom1.getMaxMate()) {
			randomRecomm1 =  (int)((Math.random()*10000)%10);
			recom1 = exerciserDao.findExerciser(randomRecomm1);
			count = countingMaxMate(randomRecomm1);
		}

		Exerciser recom2 = exerciserDao.findExerciser(randomRecomm2);
		count = countingMaxMate(randomRecomm2);
		//maxMate 초과 여부 검사
		while(count <= recom2.getMaxMate()) {
			randomRecomm2 =  (int)((Math.random()*10000)%10);
			recom2 = exerciserDao.findExerciser(randomRecomm2);
			count = countingMaxMate(randomRecomm2);
		}

		Exerciser recom3 = exerciserDao.findExerciser(randomRecomm3);
		count = countingMaxMate(randomRecomm3);
		//maxMate 초과 여부 검사
		while(count <= recom3.getMaxMate()) {
			randomRecomm3 =  (int)((Math.random()*10000)%10);
			recom3 = exerciserDao.findExerciser(randomRecomm3);
			count = countingMaxMate(randomRecomm3);
		}


		Object[] param = new Object[] {exerciserId, randomRecomm1, randomRecomm2, randomRecomm3, 0};
		jdbcUtil.setSqlAndParameters(query, param);   // JDBCUtil 에 insert into문과 매개 변수 설정

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
	public int usePoint(int exerciserId, int point) {
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
		String query = "INSERT INTO RequestStatus values (?, ?, 0)";
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
	public int reRecommendExerciser(int exerciserId, int recomId1, int recomId2, int recomId3){
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