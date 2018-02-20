package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CateVo;
import com.javaex.vo.UserVo;



@Controller
public class BlogController {

	
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService cateService;
	
	
	@RequestMapping(value ="/{id}/admin/basic", method = RequestMethod.GET)
	public String insert(@PathVariable("id") String id, 
					     Model model, 
					     HttpSession session		    
					    ) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser.getId().equals(id)) {
			BlogVo blogVo= blogService.select(id);
			model.addAttribute("blogVo",blogVo);
			String url = "upload/";
			model.addAttribute("url", url);
			
		return "/blog/admin/blog-admin-basic";
		}return "/blog/blog-main";
	  
	}
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public String mainPage(@PathVariable("id") String id, Model model) {
		BlogVo blogVo= blogService.select(id);
		model.addAttribute("blogVo",blogVo);
		String url = "upload/";
		model.addAttribute("url", url);
		
		return "/blog/blog-main";
	}
	
	@RequestMapping(value ="/{id}/admin/modify", method = RequestMethod.POST)
	public String modify(@PathVariable("id") String id,
			@RequestParam(value = "logo-file", required = false, defaultValue = "") MultipartFile logoFile,
			@RequestParam(value = "title", required = false, defaultValue = "") String blogTitle,
			HttpSession session, Model model) {
		System.out.println(logoFile);
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		int userNo = authUser.getUserNo();
		System.out.println("userNo :" + userNo);
		String url = "upload/";
		model.addAttribute("url", url);
		
		BlogVo blogVo =blogService.modify(logoFile, blogTitle, userNo);
		model.addAttribute("blogVo", blogVo);
		return "/blog/blog-main";
		
	}
	
	@RequestMapping("/{id}/admin/write")
	public String writeFrom(@PathVariable("id") String id, Model model, HttpSession session) {
		System.out.println("write 진입");
		
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		int userNo = userVo.getUserNo();
		System.out.println(userNo);
		List<CateVo> cateList = cateService.getCateList(userNo);
		model.addAttribute("cateList", cateList);
		
		
		return "/blog/admin/blog-admin-write";
	}
	
	
	
}
