package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
public UserVo login(String id, String password) {
		
		return userDao.getUser(id, password);
		
	}
public boolean getUser(String id, String password) {
	boolean result;
	UserVo userVo = userDao.getUser(id, password);
	if(userVo != null) {
		result = false;
		
	}else {
		
		result = true;
	}return result;
}
public void insert(UserVo userVo) {
	userDao.insert(userVo);
}

}
