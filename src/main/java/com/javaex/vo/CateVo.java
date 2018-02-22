package com.javaex.vo;

public class CateVo {
	
	int cateNo;
	String cateName;
	int userNo;
	String description;
	String regDate;
	int postCount;
	
	public CateVo() {
		super();
	}

	public CateVo(int cateNo, String cateName, int userNo, String description, String regDate, int postCount) {
		super();
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.userNo = userNo;
		this.description = description;
		this.regDate = regDate;
		this.postCount = postCount;
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

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}

	@Override
	public String toString() {
		return "CateVo [cateNo=" + cateNo + ", cateName=" + cateName + ", userNo=" + userNo + ", description="
				+ description + ", regDate=" + regDate + ", postCount=" + postCount + "]";
	}


	

}
