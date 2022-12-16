package model.service;

import java.util.List;
import model.dao.RecordDao;
import model.Record;

public class RecordManager {
	private static RecordManager recordMgr = new RecordManager();
	private RecordDao recordDao;
	// private ExerciserDao exerciserDao;

	private RecordManager() {
		try {
			recordDao = new RecordDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RecordManager getInstance() {
		return recordMgr;
	}

	public Record findRecordDetails(int recordId) {
		return recordDao.findRecordDetails(recordId);
	}

	// exerciser가 작성한 모든 Record 조회
	public List<Record> findRecordList(int exerciserId, int currentPage, int countPerPage) {
		return recordDao.findRecordList(exerciserId, currentPage, countPerPage);
	}

	// 모든 exerciser의 전체 운동 기록 조회
	public List<Record> findAllRecords() {
		return recordDao.findAllRecords();
	}

	public int insertRecord(String title, String creationDate, int totalTime, int category, String routine, String diet,
			String photo, int shareOption, int exerciserId) {
		return recordDao.insertRecord(title, creationDate, totalTime, category, routine, diet, photo, shareOption,
				exerciserId);
	}

	// 게시물의 primaryKey인 recordId 전달받아 해당 recordId의 게시물을 삭제하는 메소드
	public int deleteRecord(int recordId) {
		return recordDao.deleteRecord(recordId);
	}
	
	// recordId, title, creationDate, totalTime, category, routine, diet, photo, shareOption, exerciserId
	public int updateRecord(int recordId, String title, String creationDate, int totalTime, int category,
			String routine, String diet, String photo, int shareOption, int exerciserId) {
		return recordDao.updateRecord(recordId, title, creationDate, totalTime, category, routine, diet, photo, shareOption, exerciserId);
	}

	// 카테고리에 따라 전체 사용자의 전체 기록 조회 메소드
	public List<Record> findRecordListByCategory(int category) {
		return recordDao.findRecordListByCategory(category);
	}

	public int findMyRecordCnt(int exerciserId) {
		return recordDao.findMyRecordCnt(exerciserId);
	}
	
	public List<Record> getRecordList(int startRow, int pageSize){
		return recordDao.getRecordList(startRow, pageSize);
	}
	
	public List<Record> findAllExerciserRecords(int currentPage, int countPerPage){
		return recordDao.findAllExerciserRecords(currentPage, countPerPage);
	}
	
	public int getTotalPages(int countPerPage) {
		return recordDao.getTotalPages(countPerPage);
	}
}
