package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlsession;
	
	public int insertpost(Map postMap) {
		int result = sqlsession.insert("post.insertPost", postMap);
		return result;
	}
}
