<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>JBlog</title>
<%-- <link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"> --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jblog.css">
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script> --%>
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
					
						<c:if test="${(postList[0] != null)}">
							
								<c:choose >
									<c:when test="${param.selectPost==null }">
										<h4>${postList[0].postTitle}</h4>
										<p>
											${postList[0].postContent}
										</p>
									</c:when>
									<c:otherwise>
										<c:forEach items="${postList}" var="p" varStatus="s" >
											<c:if test="${postList[s.index].postNo==param.selectPost}">
												<h4>${p.postTitle}</h4>
												<p>
													${p.postContent}
												</p>
											</c:if>
										</c:forEach>
									</c:otherwise>
								</c:choose>
								
								
								
								
						</c:if>		
						
						<ul class="blog-list">
						<c:forEach items="${postList }" var = "postvo">	
						<li><a href="${pageContext.request.contextPath }/${authUser.id}?cateNo=${postvo.cateNo}&selectPost=${postvo.postNo}">${postvo.postTitle }</a><span>${postvo.regDate }</span></li>		
						</c:forEach>
						</ul>

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
				<li><a href="${pageContext.request.contextPath}/${id}/">전체</a></li>
				<c:forEach items="${cateList }" var = "cateVo">
				<li><a href="${pageContext.request.contextPath}/${id}/?cateNo=${cateVo.cateNo}">${cateVo.cateName }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<!-- 푸터 -->
	 <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- 푸터 -->
		
	</div>
</body>
</html>