package main.java.test;

import main.java.Static.Dao.*;

public class AttendanceTest {
	public static void main(String[] args) {
	staticDao dao = new staticDao();
	int r = dao.checkAttendance(2);
	
	System.out.println(r);
	}
	
}
