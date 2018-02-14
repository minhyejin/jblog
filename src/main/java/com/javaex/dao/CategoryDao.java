package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public int createcate(int userNo) {
		return sqlsession.insert("category.createcate", userNo);
	}
	
}
