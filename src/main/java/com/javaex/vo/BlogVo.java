package com.javaex.vo;

public class BlogVo {
	int userNo;
	String blogTitle;
	String logoFile;
	
	
	public BlogVo() {
	}


	public BlogVo(int userNo, String blogTitle, String logoFile) {
		super();
		this.userNo = userNo;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getBlogTitle() {
		return blogTitle;
	}


	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}


	public String getLogoFile() {
		return logoFile;
	}


	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}


	@Override
	public String toString() {
		return "BlogVo [userNo=" + userNo + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + "]";
	}
	
	
	
}
