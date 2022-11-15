package main.java.test;

import java.util.List;

import main.java.Dao.RecordDao;
import main.java.Dto.Record;

public class RecordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecordDao recordDao = new RecordDao();

		Record r = recordDao.findRecord(2);
		System.out.println(r.toString());

		List<Record> list1 = recordDao.findMyRecords(1);
		List<Record> list2 = recordDao.findAllRecords();

		System.out.println(list1.toString());
		System.out.println(list2.toString());

//		recordDao.deleteRecord(3);

		int rslt = recordDao.insertRecord(4, "오운완", "2022-11-15", 2, 3, "등,어깨", "샌드위치", "사진", 1, 2);
		System.out.println(rslt);
	}

}
