package model.service;

import model.CompareStatic;
import model.dao.StaticDao;

public class StaticManager {
	private static StaticManager manager = new StaticManager();
	private StaticDao staticDao;

	private StaticManager() {
		try {
			staticDao = new StaticDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static StaticManager getInstance() {
		return manager;
	}

	public CompareStatic calculateStatic(int exerciserId) {
		return staticDao.calculateStatic(exerciserId);
	}
}
