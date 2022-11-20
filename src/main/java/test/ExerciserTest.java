package main.java.test;

import main.java.Dao.ExerciserDao;
import main.java.Inbody.Dao.InbodyDao;

public class ExerciserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciserDao dao = new ExerciserDao();
//		dao.findExerciser(1);
//		dao.deleteExerciser("0000");

//		int r2 = dao.deleteExerciser("inwoo0924");
//		System.out.println(r2);

		InbodyDao inbody = new InbodyDao();
		int r = inbody.insertInbody(1, 171, 77, 16, 31, 6, "2022-11-10", 4);
		System.out.println(r);

	}

}