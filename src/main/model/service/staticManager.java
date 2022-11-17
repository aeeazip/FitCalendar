package main.model.service;

import main.java.Dao.staticDao;
public class staticManager {
	private static staticManager manager = new staticManager();
	private staticDao staticDao;
	
	private staticManager() {
		try {
			staticDao = new staticDao();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public static staticManager getInstance() {
		return manager;
	}

	public int checkAttendance(int exerciserId) {
		return staticDao.checkAttendance(exerciserId);
	}
}
