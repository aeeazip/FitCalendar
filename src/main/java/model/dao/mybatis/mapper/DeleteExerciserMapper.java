package model.dao.mybatis.mapper;

public interface DeleteExerciserMapper {
	public int deleteAttendance(int deleteId);
	public int deleteFitmate(int deleteId);
	public int deleteInbody(int deleteId);
	public int deleteMatchingStatus(int deleteId);
	public int deleteMessage(int deleteId);
	public int deleteRecommendList(int deleteId);
	public int deleteRecord(int deleteId);
	public int deleteToExercise(int deleteId);
	public int deleteExerciser(int deleteId) ;
}
