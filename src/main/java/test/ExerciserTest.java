package main.java.test;

import main.java.Dao.ExerciserDao;

public class ExerciserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciserDao dao = new ExerciserDao();
//		dao.findExerciser(1);
//		dao.deleteExerciser("0000");
		int r = dao.insertExerciser(6, "1234", "hjhj", "hi", "헬스", "estp", "F", "hj00");
		System.out.println(r);
	}

}