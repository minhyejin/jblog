package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;


@Repository
public class BlogDao {
	@Autowired
	private SqlSession sqlsession;
	public int insert(BlogVo blogVo) {
		int result = sqlsession.insert("blog.insertblog",blogVo);
		
		return result;
	}
	public BlogVo selectblog(String id) {
		return sqlsession.selectOne("blog.selectblog", id);
	}
}
