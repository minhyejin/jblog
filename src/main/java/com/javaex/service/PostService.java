package com.javaex.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.postVo;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	
	public int writepost(postVo postvo) {
		 return postDao.insertpost(postvo);
	}
	
	public List<postVo> getpostList(int userNo,int cateNo) {
		Map<String, Object> postMap = new HashMap<>();
			postMap.put("userNo", userNo);
			postMap.put("cateNo", cateNo);	
 		
		return postDao.selectPostByCateNo(postMap);	
	}
	public int selectcount(int cateNo) {
		return postDao.selectcount(cateNo);
	}
}
