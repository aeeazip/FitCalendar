package main.java.test;

import main.java.Dao.ExerciserDao;

public class ExerciserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciserDao dao = new ExerciserDao();
//		dao.findExerciser(1);
//		dao.deleteExerciser("0000");

		int r2 = dao.deleteExerciser("inwoo0924");
		System.out.println(r2);
	}

}