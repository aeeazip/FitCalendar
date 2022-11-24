package test;

import java.util.List;


import model.dao.RecordDao;
import model.Record;

public class RecordTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecordDao recordDao = new RecordDao();

		Record r = recordDao.findRecordDetails(2);
		System.out.println(r.toString());

		List<Record> list1 = recordDao.findRecordList(1);
		List<Record> list2 = recordDao.findAllRecords();

		System.out.println(list1.toString());
		System.out.println(list2.toString());

//		recordDao.deleteRecord(3);

		int rslt = recordDao.insertRecord("오운완", "2022-11-15", 2, 3, "등,어깨", "샌드위치", "사진", 1, 2);
		System.out.println(rslt);
	}

}
