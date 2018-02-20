package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CateVo;
import com.javaex.vo.UserVo;
import com.javaex.vo.postVo;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao cateDao;
	
	public void createCate(UserVo userVo) {
		int userNo = userVo.getUserNo();
		
		String defaultCategory = "미분류";
		
		Map<String, Object> cateMap = new HashMap<>();
		cateMap.put("userNo", userNo);
		cateMap.put("defaultCategory", defaultCategory);
		cateMap.put("defaultDesc", "카테고리를 지정하지 않은 경우");
		cateDao.createcate(cateMap);
	}
	public List<CateVo> getCateList(int userNo){
		List<CateVo> cateList = cateDao.selectCateList(userNo);
		return cateList;
	}
	public boolean deleteCate(int cateNo) {
		int count = cateDao.deletecate(cateNo);
		boolean result = false;
		if(count == 1) {
			result = true;
		}
		System.out.println(count + "개 카테고리 제거 완료");
		
		return result;
		
	}
	public int insertcate(CateVo cateVo) {
		return cateDao.insertcate(cateVo);
	}
	public int postinsert(postVo pvo) {
		int result = cateDao.postinsert(pvo);
		return result;
	}
}
