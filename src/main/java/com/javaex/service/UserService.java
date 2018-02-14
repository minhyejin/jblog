package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao categoryDao;
	
	public UserVo login(String id, String password) {
		
		return userDao.getUser(id, password);
		
	}
	public UserVo getUser(String id, String password) {
	
	return userDao.getUser(id, password);
	
}
	@Transactional
	public void insert(UserVo userVo) {
		int insertUserNo = userDao.insert(userVo);
		blogDao.insert(new BlogVo(insertUserNo,"기본 블로그명","기본 로고"));
		categoryDao.createcate(userVo.getUserNo());
}
	public boolean selectId(String id) {
		boolean result;
		UserVo userVo = userDao.selectId(id);
		if(userVo!=null) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}

}
