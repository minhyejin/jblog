package com.javaex.vo;

public class CateVo {
	
	int cateNo;
	String cateName;
	int userNo;
	String description;
	String regDate;
	
	
	public CateVo() {
		super();
	}


	public CateVo(int cateNo, String cateName, int userNo, String description, String regDate) {
		super();
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.userNo = userNo;
		this.description = description;
		this.regDate = regDate;
	}


	public int getCateNo() {
		return cateNo;
	}


	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}


	public String getCateName() {
		return cateName;
	}


	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "CategoryDao [cateNo=" + cateNo + ", cateName=" + cateName + ", userNo=" + userNo + ", description="
				+ description + ", regDate=" + regDate + "]";
	}
	

}
