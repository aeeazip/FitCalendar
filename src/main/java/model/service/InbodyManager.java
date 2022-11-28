package model.service;

import model.Inbody;
import model.dao.InbodyDao;

public class InbodyManager {
	private static InbodyManager manager = new InbodyManager();
	private InbodyDao inbodyDao;

	private InbodyManager() {
		try {
			inbodyDao = new InbodyDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Inbody findInbody(int exerciserId) {
		return inbodyDao.findInbody(exerciserId);
	}

	public static InbodyManager getInstance() {
		return manager;
	}

	public int insertInbody(int height, int weight, int percentBodyFat, int skeletalMM, int visceralFat,
			String measureDate, int exerciserId) {
		return inbodyDao.insertInbody(height, weight, percentBodyFat, skeletalMM, visceralFat, measureDate,
				exerciserId);
	}
}