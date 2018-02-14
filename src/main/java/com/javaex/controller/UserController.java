package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginform() {
		
		return "/user/loginForm";
	}
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String login(@RequestParam("id") String id, 
						@RequestParam("password") String password,
						HttpSession session) {
	
		UserVo authUser = userService.login(id, password);
		System.out.println(authUser);
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
				return "/main/index";
		}else {
						
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinform() {
		
		return "/user/joinForm";
	}
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(UserVo userVo) {
		
		userService.insert(userVo);
		System.out.println(userVo.toString());
		return "/user/joinSuccess";
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(UserVo userVo,HttpSession session ) {
		session.invalidate();
		return "/user/loginForm";
	}
}