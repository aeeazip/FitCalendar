package model.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

public interface RecordMapper {
	public int insertRecord(@Param("title") String title,
			@Param("creationDate") String creationDate,
			@Param("totalTime") int totalTime, 
			@Param("category") int category, 
			@Param("routine") String routine, 
			@Param("diet") String diet, 
			@Param("photo") String photo, 
			@Param("shareOption") int shareOption, 
			@Param("exerciserId") int exerciserId);
}
