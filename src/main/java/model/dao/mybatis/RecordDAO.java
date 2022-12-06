package model.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.dao.mybatis.mapper.RecordMapper;


public class RecordDAO {
private SqlSessionFactory sqlSessionFactory;
	
	public RecordDAO() {
		String resource = "mybatis-config2.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * 레코두 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public int insertRecord(String title, String creationDate, int totalTime, int category, String routine, String diet, String photo, int shareOption, int exerciserId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(RecordMapper.class).insertRecord(title, creationDate, totalTime, category, routine, diet, photo, shareOption, exerciserId);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}

}
