package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CateVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public int createcate(Map categoryMap) {
		int result = sqlsession.insert("category.createcate", categoryMap);
		return result;
	}
	public List<CateVo> selectCateList(int userNo){
		List<CateVo> cateList = sqlsession.selectList("category.selectCategoryListByUserNo", userNo);
		return cateList;
	}
	
}
