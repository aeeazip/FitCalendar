package test;

import model.dao.MatchingDao;
import model.dao.RecommendDao;

public class MatchingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatchingDao mDao = new MatchingDao();
		RecommendDao rDao = new RecommendDao();
		
		//int result = mDao.createOption(10, "T");
		//System.out.println(result);
		
		//int result1 = mDao.createOption(11, "T");
		//System.out.println(result1);
		
		//System.out.println(mDao.optionChange(10, 5));
		//System.out.println(mDao.optionChange(11, 5));
		
		//System.out.println(mDao.showOption(10));
		
		//System.out.println(mDao.acceptRecommend(10, 11));
		//System.out.println(mDao.acceptRecommend(12, 13));		
		//System.out.println(mDao.acceptRecommend(14, 15));

		
		//System.out.println(rDao.usePoint(10, 5));
		System.out.println(rDao.usePoint(11, 5));
	}

}
