package model.service;

import model.dao.mybatis.AttendanceDao;

public class AttendanceManager {

	private static AttendanceManager manager = new AttendanceManager();
	//private AttendanceDao attendanceDao;
	private AttendanceDao attendanceDao;

	private AttendanceManager() {
		try {
			attendanceDao = new AttendanceDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AttendanceManager getInstance() {
		return manager;
	}

	public int checkAttendance(int exerciserId) {
		return attendanceDao.checkAttendance(exerciserId);
	}

}
