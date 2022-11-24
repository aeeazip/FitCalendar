package test;

import model.dao.StaticDao;

public class AttendanceTest {
	public static void main(String[] args) {
		StaticDao dao = new StaticDao();
		int r = dao.checkAttendance(2);

		System.out.println(r);
	}

}
