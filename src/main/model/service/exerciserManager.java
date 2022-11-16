package main.model.service;
import main.java.Dto.*;
import main.java.Dao.*;

public class exerciserManager {
	private static exerciserManager manager = new exerciserManager();
	private ExerciserDao exerciserDao;
	
	private exerciserManager() {
		try {
			exerciserDao = new ExerciserDao();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static exerciserManager getInstance() {
		return manager;
	}
	
	
	public Exerciser findExerciserProfile(String id) {
		return exerciserDao.findExerciserProfile(id);
	}
	
	public Exerciser updateExerciserProfile(Exerciser exerciser) {
		return exerciserDao.updateExerciserProfile(exerciser);
	}
	
}
