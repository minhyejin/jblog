package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CateVo;
import com.javaex.vo.UserVo;


@Controller
public class ApiCategoryController {
	@Autowired
	private CategoryService cateService;
	@ResponseBody
	@RequestMapping(value ="/api/cate",method = RequestMethod.POST)
	public List<CateVo> category(@RequestBody UserVo userVo ) {
	
		List<CateVo> cateList = cateService.getCateList(userVo.getUserNo());
		return cateList;
	}

	@ResponseBody
	@RequestMapping(value = "/api/addCate", method = RequestMethod.POST)
	public CateVo addcate(@RequestBody CateVo cateVo) {
		int result = cateService.insertcate(cateVo);
		if(result==1) {
			return cateVo;
		}else {
			return null;
		}
		
	}
	@ResponseBody
	@RequestMapping(value = "/api/deletecate", method = RequestMethod.POST)
	public boolean deletecate(@RequestParam("cateNo") int cateNo) {
		boolean result =cateService.deleteCate(cateNo);
		return result;
		
	}
}
