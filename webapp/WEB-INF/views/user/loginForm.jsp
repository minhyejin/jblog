<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		
			 <!-- /header -->
		 <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		
		<form class="login-form" method="get" action="${pageContext.request.contextPath }/user/login">
      		<label>아이디</label> 
      		<input type="text" name="id">
      		
      		<label>패스워드</label> 
      		<input type="password" name="password">
      		
      		<c:if test = "${'fail'== param.result }">
				<p class="form-error"> 로그인이 실패하였습니다. 확인 후 다시 로그인 해주세요.</p>
		   </c:if>
      		
      		<input type="submit" value="로그인">
		</form>
		
	</div>
	<div id="dialog-message" title="" style="display:none">
  		<p></p>
	</div>
</body>
</html>