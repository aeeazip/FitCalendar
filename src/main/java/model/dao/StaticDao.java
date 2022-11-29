package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.CompareInbody;
import model.CompareStatic;

public class StaticDao {
	private JDBCUtil jdbcUtil = null; // JDBCUtil 참조 변수 선언

	public StaticDao() { // 생성자
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성 및 활용

	}

	public CompareStatic calculateStatic(int exerciserId) {
		ArrayList<CompareInbody> list = new ArrayList<CompareInbody>();
		CompareInbody c_inbody;
		CompareStatic c_static;
		int weeklyCount = 0;
		int monthlyCount = 0;

		String query = "SELECT percentbodyfat, skeletalmm, visceralfat \r\n"
				+ "FROM (SELECT percentbodyfat, skeletalmm, visceralfat, measuredate FROM inbody WHERE exerciserid = ? ORDER BY inbodyid DESC)\r\n"
				+ "WHERE rownum <=2";
		Object[] param = new Object[] { exerciserId };
		jdbcUtil.setSqlAndParameters(query, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				int bodyfat = rs.getInt("percentbodyfat");
				int skeletalmm = rs.getInt("skeletalmm");
				int visceralfat = rs.getInt("visceralfat");

				c_inbody = new CompareInbody(bodyfat, skeletalmm, visceralfat);
				list.add(c_inbody);

			}

			String query2 = "SELECT count(*) AS monthlyCount \r\n" + "FROM ATTENDANCE\r\n"
					+ "WHERE creationdate >= sysdate- 30 AND exerciserid = ?";

			Object[] param2 = new Object[] { exerciserId };
			jdbcUtil.setSqlAndParameters(query2, param2);

			ResultSet rs2 = jdbcUtil.executeQuery();
			if (rs2.next()) {
				monthlyCount = rs2.getInt("monthlyCount");
				System.out.println("52행 : " + monthlyCount);
			}

			String query3 = "SELECT count(*) AS weeklyCount \r\n" + "FROM ATTENDANCE\r\n"
					+ "WHERE creationdate >= sysdate- 7 AND exerciserid = ?";

			Object[] param3 = new Object[] { exerciserId };
			jdbcUtil.setSqlAndParameters(query3, param3);

			ResultSet rs3 = jdbcUtil.executeQuery();
			if (rs3.next()) {
				weeklyCount = rs3.getInt("weeklyCount");
				System.out.println("64행 : " + weeklyCount);
			}

			int c_fat;
			int c_muscle;
			int c_vfat;

			if (list.size() >= 2) {
				c_fat = list.get(1).getPercentFat() - list.get(0).getPercentFat();
				c_muscle = list.get(1).getMuscle() - list.get(0).getMuscle();
				c_vfat = list.get(1).getVisceralFat() - list.get(0).getVisceralFat();
			} else {
				c_fat = list.get(0).getPercentFat();
				c_muscle = list.get(0).getMuscle();
				c_vfat = list.get(0).getVisceralFat();
				// 여기 다시 생각
			}
			c_static = new CompareStatic(weeklyCount, monthlyCount, c_fat, c_muscle, c_vfat);

			return c_static;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;

	}
}
