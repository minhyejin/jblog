package com.javaex.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class CategoryController {	

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/{id}/admin/cate")
	public String cateForm(@PathVariable("id") String id, Model model) {
		BlogVo blogVo = blogService.select(id);
		model.addAttribute("blogVo", blogVo);
		return "/blog/admin/blog-admin-cate";
	}
	
}
