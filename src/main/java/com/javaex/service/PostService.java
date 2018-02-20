package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	
	public void writepost(String postTitle, String postContent, int catepostno) {
		Map<String, Object> postMap = new HashMap<>();
		postMap.put("postTitle", postTitle);
		postMap.put("postContent", postContent);
		postMap.put("cateNo", catepostno);
		
		int result = postDao.insertpost(postMap);
		System.out.println(result);
	}
}
