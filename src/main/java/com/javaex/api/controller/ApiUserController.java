package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class ApiUserController {
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping(value ="/user/api/idcheck",method = RequestMethod.POST)
	public boolean idcheck(@RequestBody UserVo userVo) {
		System.out.println(userVo);
		return userService.selectId(userVo.getId());
	}
	
}
