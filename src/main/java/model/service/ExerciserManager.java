package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Exerciser;
import model.dao.ExerciserDao;
import model.dao.mybatis.DeleteExerciserDao;

public class ExerciserManager {
	private static ExerciserManager manager = new ExerciserManager();
	private ExerciserDao exerciserDao;
//	private DeleteExerciserDao deleteDao;

	private ExerciserManager() {
		try {
			exerciserDao = new ExerciserDao();
//			deleteDao = new DeleteExerciserDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ExerciserManager getInstance() {
		return manager;
	}

	public Exerciser findExerciser(String id) {
		return exerciserDao.findExerciserById(id);
	}

	public Exerciser findExerciserProfile(String id) {
		return exerciserDao.findExerciserProfile(id);
	}

	public int insertExerciser(String password, String nickname, String explanation, String speciality,
			String personality, String gender, String id) throws SQLException, ExistingUserException {

		if (exerciserDao.existingUser(id) == true) {
			System.out.println(id + "는 존재하는 아이디입니다.");
			throw new ExistingUserException(id + "는 존재하는 아이디입니다.");
		}
		return exerciserDao.insertExerciser(password, nickname, explanation, speciality, personality, gender, id);
	}

	public int updateExerciser(int exerciserId, String nickname, String explanation, String speciality,
			String personality) {
		return exerciserDao.updateExerciser(exerciserId, nickname, explanation, speciality, personality);
	}

	public int deleteExerciser(int deleteId, String password) {
		if (exerciserDao.findExerciser(deleteId).getPassword().equals(password)) {
			exerciserDao.deleteAttendance(deleteId);
			exerciserDao.deleteFitmate(deleteId);
			exerciserDao.deleteInbody(deleteId);
			exerciserDao.deleteMatchingStatus(deleteId);
			exerciserDao.deleteMessage(deleteId);
			exerciserDao.deleteRecommendList(deleteId);
			exerciserDao.deleteRecord(deleteId);
			exerciserDao.deleteToExercise(deleteId);
			
			return exerciserDao.deleteExerciser(deleteId);
		}
		

		return 0;
	}

	public Exerciser findExerciserById(int exerciserId) {
		return exerciserDao.findExerciser(exerciserId);
	}

	public int updatePoint(int exerciserId) {
		return exerciserDao.updatePoint(exerciserId);
	}

	public int updatePoint2(int exerciserId) {
		return exerciserDao.updatePoint2(exerciserId);
	}

	public int existingAttendance(int exerciserId) throws SQLException {
		return exerciserDao.existingAttendance(exerciserId);
	}

	public boolean login(String userId, String password)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
		Exerciser exerciser = findExerciser(userId);
		if (exerciser.matchPassword(password) == false) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}
	//메인 출력용 사용자 정보
	public Exerciser showInfo(int exerciserId, String nickName, int point,  String explanation, String gender) {
		Exerciser exerciser = exerciserDao.showInfo(exerciserId);
		return exerciser;
	}
	//랭킹1,2,3위 보여주기
	public List<Exerciser> showRanking(){
		return exerciserDao.showRanking();
	}
}