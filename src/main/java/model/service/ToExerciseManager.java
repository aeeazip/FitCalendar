package model.service;

import java.util.ArrayList;

import model.ToExercise;
import model.dao.ToExerciseDao;

public class ToExerciseManager {

	private static ToExerciseManager manager = new ToExerciseManager();
	private ToExerciseDao toExerciseDao;

	private ToExerciseManager() {
		try {
			toExerciseDao = new ToExerciseDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ToExerciseManager getInstance() {
		return manager;
	}

	public ArrayList<ToExercise> findToExercise(int exerciserId) {
		return toExerciseDao.findToExercise(exerciserId);
	}

	public ArrayList<ToExercise> addToExercise(int exerciserId, String content) {
		return toExerciseDao.addToExercise(exerciserId, content);
	}

	public ArrayList<ToExercise> checkToExercise(int exerciserId, int itemId) {
		return toExerciseDao.checkToExercise(exerciserId, itemId);
	}

	public ArrayList<ToExercise> deleteToExercise(int exerciserId, int itemId) {
		return toExerciseDao.deleteToExercise(exerciserId, itemId);
	}

}
