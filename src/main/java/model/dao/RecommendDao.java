package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Exerciser;
import model.MatchingStatus;
import model.RecommendList;
import model.HeightRange;
import model.PercentBodyFatRange;
import model.WeightRange;

public class RecommendDao {
	private JDBCUtil jdbcUtil = null;
	private ExerciserDao exerciserDao = new ExerciserDao();


	public RecommendDao() { 
		jdbcUtil = new JDBCUtil(); 
	}

	public RecommendList displayExerciser(int exerciserId) {
		String query = "SELECT exerciserId, recommId1, recommId2, recommId3, count FROM RecommendList WHERE exerciserId = ?";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);
		RecommendList recommend = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int exerciser_id = rs.getInt("exerciserId");
				int recomId1 = rs.getInt("recommId1");
				int recomId2 = rs.getInt("recommId2");
				int recomId3 = rs.getInt("recommId3");
				int count = rs.getInt("count");
				
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

	public List<MatchingStatus> showGetRecommendList(int exerciserId) {
		String query = "SELECT * FROM matchingstatus WHERE receiverId = ? AND status = 2";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);
		List<MatchingStatus> statusList = new ArrayList<MatchingStatus>();
		MatchingStatus status = null;

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			System.out.println("result실행");
			while (rs.next()) {
				int sender = rs.getInt("senderId");
				int reciever = rs.getInt("receiverid");
				int status_int = rs.getInt("status");
	
				status = new MatchingStatus(sender, reciever, status_int);
				statusList.add(status);

			}
			return statusList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public RecommendList recommendExerciser(int exerciserId, int height1, int height2, int weight1, int weight2, int percentBodyFat1, int percentBodyFat2){
		usePoint(exerciserId, 30);
		int count = 1;
		int randomRecomm1;
		int randomRecomm2;
		int randomRecomm3;

		RecommendList recommendList = null;
		List<Integer> recomm_list = new ArrayList<Integer>();
		
		String query = "SELECT * "
				+ "FROM INBODY i1, (SELECT exerciserId, MAX(inbodyid) inbodyid FROM inbody GROUP BY exerciserid) i2 "
				+ "where (i1.inbodyid = i2.inbodyid) AND (height BETWEEN ? AND ? ) AND  (weight BETWEEN ? AND ? ) AND (percentbodyfat BETWEEN ? AND ? )";
		Object[] param = new Object[] {height1, height2, weight1, weight2, percentBodyFat1, percentBodyFat2 };
		jdbcUtil.setSqlAndParameters(query, param);  

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			while (rs.next()) {
				if(count > 3)break;
				int recommendId = rs.getInt("exerciserId");
				recomm_list.add(recommendId);
				count++;
			}
			randomRecomm1 = recomm_list.get(0);
			randomRecomm2 = recomm_list.get(1);
			randomRecomm3 = recomm_list.get(2);
			
			String query2 = "INSERT INTO recommendlist(exerciserId, recommid1, recommid2, recommid3, count) VALUES (?, ?, ?, ?, 0)";
			Object[] param2 = new Object[] {exerciserId, randomRecomm1, randomRecomm2, randomRecomm3};
			jdbcUtil.setSqlAndParameters(query2, param2);  
			
			int result = jdbcUtil.executeUpdate();
			if(result > 0)
				recommendList = new RecommendList(exerciserId, randomRecomm1, randomRecomm2, randomRecomm3, 0);
			return recommendList; 
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); 
		}
		return recommendList;   
	}

	public int usePoint(int exerciserId, int point) {
		String query = "UPDATE exerciser SET point = NVL(point, 0) - ? WHERE exerciserId = ?";
		Object[] param = new Object[] { point, exerciserId };
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

	public int requestFitmate(int myExerciserId, int yourExerciserId) {
		String query = "INSERT INTO matchingStatus values (?, ?, 2)";
		Object[] param = new Object[] { myExerciserId, yourExerciserId };
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

	public int reRecommendExerciser(int exerciserId){
		System.out.println("reRecommend Dao");
		String query = "UPDATE recommendlist SET count=count+1 " + "WHERE exerciserId = ? ";
		Object[] param = new Object[] {exerciserId};
		jdbcUtil.setSqlAndParameters(query, param); 

		try {
			int result = jdbcUtil.executeUpdate();
			System.out.println(result);
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

	public int countingMaxMate(int exerciserId) {
		String query = "SELECT COUNT(*) AS c FROM fitmate WHERE exerciser1 = ? OR exerciser2 = ? ";
		Object[] param = new Object[] { exerciserId,exerciserId};
		jdbcUtil.setSqlAndParameters(query, param);
		int count = 0;

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
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
	
	public int countZero(int exerciserId) {
		System.out.println("countzero dao");
		String query = "UPDATE recommendlist SET count = 0 WHERE exerciserId = ? ";
		Object[] param = new Object[] {exerciserId};
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
	
	public WeightRange calculateWeightrange(int weightOptions) {
		WeightRange w_range = null;
		String query = "SELECT * FROM WeightOptions WHERE weightId = ? ";
		Object[] param = new Object[] { weightOptions };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int weight1 = rs.getInt("weight1");
				int weight2 = rs.getInt("weight2");
				w_range = new WeightRange(weightOptions, weight1, weight2);
				return w_range;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return w_range;
	}
	
	public HeightRange calculateHeightrange(int heightOptions) {
		HeightRange h_range = null;
		String query = "SELECT * FROM HeightOptions WHERE heightId = ? ";
		Object[] param = new Object[] { heightOptions };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int height1 = rs.getInt("height1");
				int height2 = rs.getInt("height2");
				h_range = new HeightRange(heightOptions, height1, height2);
				return h_range;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return h_range;
	}
	
	public PercentBodyFatRange calculatePercentBodyFatrange(int percentBodyFatOptions) {
		PercentBodyFatRange p_range = null;
		String query = "SELECT * FROM PercentBodyFatOptions WHERE percentBodyFatId = ? ";
		Object[] param = new Object[] { percentBodyFatOptions };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int percentBodyFat1 = rs.getInt("percentBodyFat1");
				int percentBodyFat2 = rs.getInt("percentBodyFat2");
				p_range = new PercentBodyFatRange(percentBodyFatOptions, percentBodyFat1, percentBodyFat2);
				return p_range;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return p_range;
	}

}