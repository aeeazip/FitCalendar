package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Exerciser;
import model.Fitmate;
import model.MatchingStatus;
import model.RecommendList;

public class MatchingDao {
	private JDBCUtil jdbcUtil = null; 
	private ExerciserDao exerciserDao = new ExerciserDao();

	public MatchingDao() {
		jdbcUtil = new JDBCUtil();
	}

	public int createOption(int exerciserId, String useMatchSvc) {
		String query = "UPDATE exerciser SET useMatchSvc = ? WHERE exerciserId = ?";
		Object[] param = new Object[] { useMatchSvc, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result; 
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	public int optionChange(int exerciserId, int maxMate, String useMatchSvc) {
		String query = "UPDATE exerciser SET maxMate = ?, useMatchSvc = ? WHERE exerciserId = ?";
		Object[] param = new Object[] { maxMate, useMatchSvc, exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result; 
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); 
		}
		return 0;
	}

	public Exerciser showOption(int exerciserId) {
		String query = "SELECT exerciserId, useMatchSvc, NVL(maxMate,0) FROM exerciser WHERE exerciserId =?";
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

	public int acceptRecommend(int myExerciserId, int yourExerciserId) {
		String query = "INSERT INTO fitmate VALUES (?, ?)";
		Object[] param = new Object[] { myExerciserId, yourExerciserId };
		jdbcUtil.setSqlAndParameters(query, param); 

		try {
			int result = jdbcUtil.executeUpdate(); 
			
			String query2 = "UPDATE matchingStatus SET status = 1 WHERE (senderId =? AND receiverId = ?) OR (receiverId =? AND senderId = ?)";
			Object[] param2 = new Object[] { myExerciserId, yourExerciserId, myExerciserId, yourExerciserId };
			jdbcUtil.setSqlAndParameters(query2, param2);
			result = jdbcUtil.executeUpdate();
			System.out.println("acceptRecommend result: " + result);
			return result; 
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); 
		}
		return 0;
	}

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
			jdbcUtil.close(); 
		}
		return 0;
	}

	public int matchingRefuse(int myExerciserId, int yourExerciserId) {
		String query = "UPDATE matchingStatus SET status = 3 WHERE senderId =? AND receiverId = ?";
		Object[] param = new Object[] { yourExerciserId, myExerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result; 

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	public int notifyMatching(int sender, int receiver) {			
		String query = "INSERT INTO message(msgid, content, senderid, receiverid) VALUES (MSGIDSEQ.nextval, ?, ?, ?)";
		Object[] param = new Object[] { "Fitmate 간 메시지가 활성화되었습니다.", sender, receiver};
		jdbcUtil.setSqlAndParameters(query, param);
		try {
			int result1 = jdbcUtil.executeUpdate(); 	
			return result1;
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); 
		}
		return 0;
	}

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

			return (result1 + result2); 
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
	      String query = "SELECT * FROM fitmate WHERE exerciser1 = ? OR exerciser2 = ?";
	      Object[] param = new Object[] { exerciserId, exerciserId };
	      jdbcUtil.setSqlAndParameters(query, param);
	      System.out.println(exerciserId);
	      int exerciser1;
	      int exerciser2;
	      Fitmate fitmate;
	      System.out.println("showFitmateList 실행");

	      try {
	         ResultSet rs = jdbcUtil.executeQuery();

	         List<Fitmate> fitmateList = new ArrayList<Fitmate>();
	         while (rs.next()) {
	            exerciser1 = rs.getInt("exerciser1");
	            exerciser2 = rs.getInt("exerciser2");
	            fitmate = new Fitmate(exerciser1, exerciser2);

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
