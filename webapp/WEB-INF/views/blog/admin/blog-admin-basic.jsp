﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>

	<div id="container">
		
		 <!-- /header -->
		 <c:import url="/WEB-INF/views/include/blogheader.jsp"></c:import>
		
		
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected"><a href="">기본설정</a></li>
					<li><a href="">카테고리</a></li>
					<li><a href="">글작성</a></li>
				</ul>
				
				<form action="${pageContext.request.contextPath}/${authUser.id}/admin/modify" method="post" enctype = "multipart/form-data">
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그제목</td>
			      			<td><input type="text" size="40" name="title" value="${blogVo.blogTitle }"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td>
			      			<td><img src="${pageContext.request.contextPath}/${url}${blogVo.logoFile }"></td>      			
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" name="logo-file"></td>      			
			      		</tr>           		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td class="s"><input type="submit" value="기본설정 변경"></td>      			
			      		</tr>           		
			      	</table>
			      	<input type="hidden" name="userNo" value="${blogVo.userNo }" /> 
				</form>
			</div>
		</div>
		
		<!-- 푸터 -->
		 <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- 푸터 -->
	
	</div>
</body>
</html>