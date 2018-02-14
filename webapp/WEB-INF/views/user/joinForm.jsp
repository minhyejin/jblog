<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<title>JBlog</title>
<link rel="stylesheet" href="/jblog/assets/css/jblog.css">
</head>
<body>
	<div class="center-content">
		
		 <!-- /header -->
		 <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
 		
		<form class="join-form" id="join-form" method="get" action="${pageContext.request.contextPath}/user/join">
			<label class="block-label" for="name">이름</label>
			<input type="text" name="userName"  value="" />
			
			<label class="block-label" for="id">아이디</label>
			<input type="text" name="id"  value="" />
			<input id="btn-checkid" type="button" value="id 중복체크">
			<div id ="checkmessage">
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
			</div>

			<label class="block-label" for="password">패스워드</label>
			<input type="password" name="password"  value="" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>

</body>

<script type="text/javascript">
	$("#btn-checkid").on("click",function(){
	
	var id = $("[name=id]").val();

		 
	$.ajax({
		
		url : "${pageContext.request.contextPath }/user/api/idcheck",		
		type : "get",
		//contentType : "application/json",
		data : {id : id},
		
		//받을 때 데이터 타입
		dataType : "json",
		success : function(result){
			console.log(result);
			if(result==true){
				$("#checkmessage").text("사용할 수 있는 id 입니다.");
				
			}else {
				$("#checkmessage").text("사용할 수 없는 id 입니다.");
				
			}
			/*성공시 처리해야될 코드 작성*/
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
});

</script>
</html>