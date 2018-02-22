<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	 <c:import url="/WEB-INF/views/include/blogheader.jsp"></c:import>

		
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/modify">기본설정</a></li>
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/cate">카테고리</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write">글작성</a></li>
				</ul>
				
				
				<form action="${pageContext.request.contextPath}/${authUser.id}/admin/writepost" method="get">
			      	<table class="admin-cat-write">
			      		<tr>
			      			<td class="t">제목</td>
			      			<td>
			      				<input type="text" size="60" name="postTitle">
				      			<select name="cateNo">
				      			<c:forEach items = "${requestScope.cateList }" var = "cateVo" >
				      				<option value = "${cateVo.cateNo }">${cateVo.cateName }</option>
				      			</c:forEach>
				      			</select>
				      		</td>
			      		</tr>
			      		<tr>
			      			<td class="t">내용</td>
			      			<td><textarea name="postContent"></textarea></td>
			      		</tr>
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td class="s"><input type="submit" value="포스트하기"></td>
			      		</tr>
			      	</table>
				</form>
			</div>
		</div>
		
		<!-- 푸터 -->
	 <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- 푸터 -->
		
	</div>
</body>
</html>