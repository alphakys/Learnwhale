package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.ProblemDao;
import com.javaex.vo.CategoryVo;

@Service
public class ProblemService {
	
	@Autowired
	private  ProblemDao proDao;
		
		public List<CategoryVo>getCategory(int userNo) {
			System.out.println("CateService- getCategory");
			
			return proDao.selectCategory(userNo);
			
		}
	
	
}
