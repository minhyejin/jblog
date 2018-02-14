<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


		<!-- 블로그 헤더 -->
		<div id="header">
			<h1>${blogVo.blogTitle}</h1>
			<ul>
			<c:choose>
			
				<c:when test = "${authUser == null }">
				<li><a href="${pageContext.request.contextPath }/user/loginForm">로그인</a></li>
				</c:when>
		
				<c:otherwise>	
				<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath }/${authUser.id}/admin/basic">내블로그 관리</a></li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>