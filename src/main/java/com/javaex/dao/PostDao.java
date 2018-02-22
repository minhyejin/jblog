package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.postVo;

@Repository
public class PostDao {
	@Autowired
	private SqlSession sqlsession;
	
	public int insertpost(postVo postvo) {
		 return sqlsession.insert("post.insertPost", postvo);
		
	}
	public List<postVo> selectPostByCateNo(Map<String, Object> postMap) {
		System.out.println(postMap);
		return sqlsession.selectList("post.selectpostListBycateNo",postMap); 
	}
	public int selectcount(int cateNo) {
		return sqlsession.selectOne("post.selectCountPost",cateNo);
	}
	
}
