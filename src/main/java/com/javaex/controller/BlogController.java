package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.javaex.service.BlogService;

import com.javaex.vo.BlogVo;


@Controller
public class BlogController {

	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public String insert(@PathVariable("id") String id, Model model ) {
		
	  BlogVo blogVo= blogService.select(id);
	  model.addAttribute("blogVo",blogVo);
		return "/blog/blog-main";
	}
	@RequestMapping(value = "/{id}/admin/basic", method = RequestMethod.GET)
	public String select(@PathVariable("id") String id) {
		return "/blog/admin/blog-admin-basic";
	}
}
