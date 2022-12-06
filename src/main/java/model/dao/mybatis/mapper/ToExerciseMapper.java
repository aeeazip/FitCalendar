package model.dao.mybatis.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import model.ToExercise;

public interface ToExerciseMapper {
   public ArrayList<ToExercise> findToExercise(int exerciserId);
   public int addToExercise(@Param("exerciserId") int exerciserId, @Param("content") String content);
   public int checkToExercise(@Param("exerciserId") int exerciserId, @Param("itemId") int itemId);
   public int deleteToExercise(@Param("exerciserId") int exerciserId, @Param("itemId") int itemId);
   public int unCheckToExercise(@Param("exerciserId") int exerciserId, @Param("itemId") int itemId);

}