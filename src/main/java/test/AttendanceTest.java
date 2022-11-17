package main.java.test;

import main.java.Dao.staticDao;

public class AttendanceTest {
	public static void main(String[] args) {
	staticDao dao = new staticDao();
	int r = dao.checkAttendance(2);
	
	System.out.println(r);
	}
	
}
