package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.ToExercise;
import model.dao.mybatis.mapper.ToExerciseMapper;

public class MyBatis_ToExerciseDao {
   private SqlSessionFactory sqlSessionFactory;
   
   public MyBatis_ToExerciseDao() {
      String resource = "mybatis-config4.xml";
      InputStream inputStream;
      try {
         inputStream = Resources.getResourceAsStream(resource);
      } catch (IOException e) {
         throw new IllegalArgumentException(e);
      }
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   }
   
   public ArrayList<ToExercise> findToExercise(int exerciserId) {
      SqlSession sqlSession = sqlSessionFactory.openSession();
      try {
         return sqlSession.getMapper(ToExerciseMapper.class).findToExercise(exerciserId);
      } finally {
         sqlSession.close();
      }
   }
   
   public int addToExercise(int exerciserId, String content) {

      SqlSession sqlSession = sqlSessionFactory.openSession();
      try {
         return sqlSession.getMapper(ToExerciseMapper.class).addToExercise(exerciserId, content);
      } finally {
         sqlSession.close();
      }
   }
   
   public int checkToExercise(int exerciserId, int itemId) {
      
      SqlSession sqlSession = sqlSessionFactory.openSession();
      try {
         return sqlSession.getMapper(ToExerciseMapper.class).checkToExercise(exerciserId, itemId);
      } finally {
         sqlSession.close();
      }
   }
   
   public int unCheckToExercise(int exerciserId, int itemId) {
      SqlSession sqlSession = sqlSessionFactory.openSession();
      try {
         return sqlSession.getMapper(ToExerciseMapper.class).unCheckToExercise(exerciserId, itemId);
      } finally {
         sqlSession.close();
      }
   }
   
   public int deleteToExercise(int exerciserId, int itemId) {
      SqlSession sqlSession = sqlSessionFactory.openSession();
      try {
         return sqlSession.getMapper(ToExerciseMapper.class).deleteToExercise(exerciserId, itemId);
      } finally {
         sqlSession.close();
      }
   }
}