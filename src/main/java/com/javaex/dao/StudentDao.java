package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	  public List<Map<String, Object>> selectList(int classNo) {
	  
	  return sqlSession.selectList("student.selectList", classNo); 
	  
	  }
	 
	  public int selNo(int classNo) {
		  int no = sqlSession.selectOne("student.selNo", classNo);
		  System.out.println(no);
		  return sqlSession.selectOne("student.selNo", classNo);
	  }
	  
	   
	  public int updateApprove(int[] userNo) {
		  
		  return sqlSession.update("student.updateApprove", userNo);
		  
	  }
	  
	  public int updateWait(int[] userNo) {
		  
		  return sqlSession.update("student.updateWait", userNo);
		  
	  }
	  
	  
	  public int updateDelete(int[] userNo) {
		  
		  return sqlSession.update("student.updateDelete", userNo);
		  
	  }
}
