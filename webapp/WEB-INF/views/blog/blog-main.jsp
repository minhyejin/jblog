<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JBlog</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jblog.css">
</head>
<body>

	<div id="container">
		<!-- /블로그 해더 -->
		
		 <c:import url="/WEB-INF/views/include/blogheader.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					
						<c:if test="${(postList[0] == null)}">
							<h4>등록된 글이 없습니다.</h4>
						</c:if>	
					
						<c:if test="${(postList[0] != null)
						&& (param.postNo == null)}">
							<h4>${postList[0].postTitle}</h4>
							<p>
								${postList[0].postContent}
							<p>
							<h3> ${postList[0].regDate }</h3>
						</c:if>	
						
						<c:if test="${param.postNo != null}">
							<c:forEach items="${postList }" var = "postvo">
								<c:if test="${param.postNo == postvo.postNo}">
									<h4>${postvo.postTitle }</h4>
									<p>
										${postvo.postContent }
									<p>
									<h3>${postvo.regDate }</h3>
								</c:if>	
							</c:forEach>

						</c:if>	
						
					</div>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath }/${url}${blogVo.logoFile }">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
			
				<c:forEach items="${cateList }" var = "cateVo">
				<li><a href="">${cateVo.cateName }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<!-- 푸터 -->
	 <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- 푸터 -->
		
	</div>
</body>
</html>