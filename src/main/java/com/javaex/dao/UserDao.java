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
	public int insert(UserVo userVo) {
		System.out.println(userVo.getUserNo()); //비어있을꺼야
		 sqlsession.insert("user.insert", userVo); //인서트 order="before" 타입이기 때문에 userNo 셀렉해서 vo 에 세팅됨
		 return userVo.getUserNo(); //번호를 채운상태
	}
	public UserVo selectId(String id) {
		return sqlsession.selectOne("user.selectid",id);
	}
}
