package main.java.test;

import java.util.List;

import main.java.Dao.RecordDao;
import main.java.Dto.Record;

public class RecordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecordDao recordDao = new RecordDao();
		
		Record r = recordDao.findRecord(1);
		/*System.out.println(r.toString());
		
		List<Record> list1 = recordDao.findMyRecords(1);
		List<Record> list2 = recordDao.findAllRecords();
		
		System.out.println(list1.toString());
		System.out.println(list2.toString());*/
		
		recordDao.deleteRecord(3);
	}

}
