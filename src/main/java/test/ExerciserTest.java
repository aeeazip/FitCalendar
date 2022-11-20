package main.java.test;

import main.java.Dao.ExerciserDao;

public class ExerciserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciserDao dao = new ExerciserDao();
		int r = dao.insertExerciser("3333", "코코", "하이", "헬스", "esfj", "F", "cocochannel");
		System.out.println(r);

//		dao.findExerciser(1);
//		dao.deleteExerciser("0000");

//		int r2 = dao.deleteExerciser("inwoo0924");
//		System.out.println(r2);

//		InbodyDao inbody = new InbodyDao();
//		int r = inbody.insertInbody(181, 77, 16, 31, 6, "2022-10-10", 4);
//		System.out.println(r);

	}

}