package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlsession;
	public UserVo getUser(String id, String password) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		return sqlsession.selectOne("user.selectuser",map);
	}
	public void insert(UserVo userVo) {
		 sqlsession.insert("user.insert", userVo);
	}
}
