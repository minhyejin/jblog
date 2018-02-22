package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;



@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;

	public BlogVo select(String id) {
		BlogVo blogVo = blogDao.selectblog(id);
		return blogVo;
	}
	
	public BlogVo modify(MultipartFile logoFile,String blogTitle, int userNo) {
		String saveDir = "D:\\javaStudy\\upload";
		System.out.println("modify 진입");
		BlogVo blogVo = new BlogVo();
				//원래 파일 이름
				String orgname = logoFile.getOriginalFilename();
				System.out.println("orgname"+orgname);
				//확장자
				String exname = logoFile.getOriginalFilename().substring(logoFile.getOriginalFilename().lastIndexOf("."));//.으로 구분해서 잘라줘라 
				System.out.println("exname"+exname);
				//저장파일 이름
				String savename = System.currentTimeMillis() + UUID.randomUUID().toString()+exname;//현재시간을 기준으로 랜덤하게 찍어주는 숫자 (같을 수가 없음)
				System.out.println("savename"+savename);
				//저장위치(패스)
				String filePath = saveDir + "\\" + savename;
				System.out.println("filePath"+filePath);
				//파일 사이즈
				long logoFileSize = logoFile.getSize();
				System.out.println("logoFileSize"+logoFileSize);
				//파일 복사 
				try {
					byte[] fileData =  logoFile.getBytes();
					OutputStream out = new FileOutputStream(saveDir +"/"+savename);
					BufferedOutputStream bout = new BufferedOutputStream(out);
					bout.write(fileData);
					
					if(bout !=null) {
						bout.close();
					}
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				
				blogVo.setBlogTitle(blogTitle);
				blogVo.setLogoFile(savename );
				blogVo.setUserNo(userNo);
				
				blogDao.modify(blogVo);
				
				System.out.println(blogVo.toString());
				return blogVo;
				
	}
}
