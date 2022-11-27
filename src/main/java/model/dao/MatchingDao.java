package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Exerciser;
import model.Fitmate;
import model.MatchingStatus;
import model.RecommendList;

public class MatchingDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언
	private ExerciserDao exerciserDao = new ExerciserDao();

	public MatchingDao() { // 생성자
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용
	}

	/**
	 * useMatchSvc 버튼 클릭 시, exerciser table의 useMatchSvc 값 생성
	 */
	public int createOption(int exerciserId, String useMatchSvc) {
		String query = "UPDATE exerciser SET useMatchSvc = ? WHERE exerciserId = ?";
		Object[] param = new Object[] { useMatchSvc, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
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
	 * maxMate & useMatchSvc 변경 가능 두 항목 exerciser table에 저장
	 */
	public int optionChange(int exerciserId, int maxMate, String useMatchSvc) {
		String query = "UPDATE exerciser SET maxMate = ?, useMatchSvc = ? WHERE exerciserId = ?";
		Object[] param = new Object[] { maxMate, useMatchSvc, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
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
	 * useMatchSvc, maxMate 보여주기
	 */
	public Exerciser showOption(int exerciserId) {
		String query = "SELECT exerciserId, useMatchSvc, maxMate FROM exerciser WHERE exerciserId =?";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		Exerciser exerciser = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				exerciser = new Exerciser();
				exerciser.setExerciserId(rs.getInt("exerciserId"));
				exerciser.setUseMatchSvc(rs.getString("useMatchSvc"));
				exerciser.setMaxMate(rs.getInt("maxMate"));
			}
			return exerciser;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	/**
	 * 추천 받은 것 중 한명이 수락하면 fitmate table에 새로운 행 생성
	 */
	public int acceptRecommend(int myExerciserId, int yourExerciserId) {
		String query = "INSERT INTO fitmate VALUES (?, ?)";
		Object[] param = new Object[] { myExerciserId, yourExerciserId };
		jdbcUtil.setSqlAndParameters(query, param); // JDBCUtil 에 insert into문과 매개 변수 설정

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
	 * 매칭 거절 시, recommendList에서 상대 id 없애기
	 * 
	 * @return
	 */
	public int refuseRecommend(int myExerciserId, int yourExerciserId) {

		String query = "DELETE FROM RecommendList WHERE exerciserId = ? AND (recomId1 = ? OR recomId2 = ? OR recomId3 = ?)";
		Object[] param = new Object[] { myExerciserId, yourExerciserId, yourExerciserId, yourExerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result1 = jdbcUtil.executeUpdate();
			jdbcUtil.close();

			Object[] param2 = new Object[] { yourExerciserId, myExerciserId, myExerciserId, myExerciserId };

			jdbcUtil.setSqlAndParameters(query, param2);
			int result2 = jdbcUtil.executeUpdate();

			return result1 + result2;
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
	 * 매칭 거절 시, matchingStatus의 status 2(refuse)로 수정.
	 */
	public int matchingRefuse(int myExerciserId, int yourExerciserId) {
		String query = "UPDATE matchingStatus SET status = 2 WHERE senderId =?, receiverId = ?";
		Object[] param = new Object[] { myExerciserId, yourExerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result1 = jdbcUtil.executeUpdate();

			jdbcUtil.close();

			Object[] param2 = new Object[] { yourExerciserId, myExerciserId };
			jdbcUtil.setSqlAndParameters(query, param2);

			int result2 = jdbcUtil.executeUpdate();

			return (result1 + result2); // 2가 return 되어야함

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	/**
	 * 매칭 수락 시, 메시지 활성화됐다는 메시지 보내기
	 */
	public int notifyMatching(int myExerciserId, int yourExerciserId) {
		return 0;
	}

	/**
	 * 매칭 수락 시, matchingStatus의 status 1(accept)로 수정.
	 * matchingComplete(myExerciserId, yourExerciserId)
	 */
	public int matchingComplete(int myExerciserId, int yourExerciserId) {
		String query = "UPDATE matchingStatus SET status = 1 WHERE senderId =?, receiverId = ?";
		Object[] param = new Object[] { myExerciserId, yourExerciserId };
		jdbcUtil.setSqlAndParameters(query, param);
		try {
			int result1 = jdbcUtil.executeUpdate();

			jdbcUtil.close();

			Object[] param2 = new Object[] { yourExerciserId, myExerciserId };
			jdbcUtil.setSqlAndParameters(query, param2);

			int result2 = jdbcUtil.executeUpdate();

			return (result1 + result2); // 2가 return 되어야함

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	/**
	 * exerciser의 fitmateList보여주기
	 */
	public List<Fitmate> showFitmateList(int exerciserId) {
		String query = "SELECT * FROM fitmate WHERE excerciser1 = ? OR exerciser2 = ?";
		Object[] param = new Object[] { exerciserId, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			List<Fitmate> fitmateList = new ArrayList<Fitmate>();
			while (rs.next()) {
				Exerciser exerciser1 = exerciserDao.findExerciser(rs.getInt("excerciser1"));
				Exerciser exerciser2 = exerciserDao.findExerciser(rs.getInt("exerciser2"));

				Fitmate fitmate = new Fitmate(exerciser1, exerciser2);

				fitmateList.add(fitmate);
			}
			return fitmateList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	/**
	 * exerciser의 matching 상태 확인
	 */
	public List<MatchingStatus> showSitationList(int exerciserId) {
		int receiverId;
		int status;
		MatchingStatus matchingStatus;
		String query = "SELECT * FROM matchingStatus WHERE senderId = ?";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MatchingStatus> matchingList = new ArrayList<MatchingStatus>();
		
			while (rs.next()) {
				receiverId = rs.getInt("receiverId");
				status = rs.getInt("status");
				matchingStatus = new MatchingStatus(exerciserId, receiverId, status);
				matchingList.add(matchingStatus);
			}
			return matchingList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

}
