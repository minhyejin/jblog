package com.javaex.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {	

	@RequestMapping("/{id}/admin/cate")
	public String cateForm() {
		return "/blog/admin/blog-admin-cate";
	}
	
}
