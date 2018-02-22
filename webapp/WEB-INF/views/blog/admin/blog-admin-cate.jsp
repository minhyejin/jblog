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

	<div id="container">
		
		 <c:import url="/WEB-INF/views/include/blogheader.jsp"></c:import>

		
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/modify">기본설정</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/cate">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write">글작성</a></li>
				</ul>
				
		      	<table class="admin-cat" id = "cate-area">
					
					<tr id = "cate-area-after">
						<td>카테고리 번호</td>
						<td>카테고리 이름</td>
						<td>사용자 번호</td>
						<td>내용</td>
						<td >삭제</td>
					</tr>					  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가" id = "add-cate-btn"></td>
		      		</tr>      		      		
		      	</table> 
			</div>
		</div>

		<!-- 푸터 -->
	 <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- 푸터 -->
		
	</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	 fetchList(); 
});
var userVo = {
		userNo : '${sessionScope.authUser.userNo}',
		id : '${sessionScope.authUser.id}',
		userName : '${sessionScope.authUser.userName}'
};
 	console.log(userVo);
 	
 	 function fetchList() {
 		  $.ajax({
 			url : "${pageContext.request.contextPath }/api/cate ",
 			type : "post",
 			contentType : "application/json",
 			data : JSON.stringify(userVo),
 			dataType : "json",
 			success : function(cateList){
 				console.log(cateList);
 				for(var i = 0; i <cateList.length; i++){
 					render(cateList[i],"down");
 				}
 			},
 			error : function(XHR, status, error) {
 			console.error(status + " : " + error);
 			}
 			});  
 		}; 
 		
 		
 	 	function render(cateVo , updown) {
 			var str = "";
 			str=str+"<tr id = 'cate"+cateVo.cateNo+"'>";
 			str=str+"	<td class = 'cateNo'>"+cateVo.cateNo+"</td>";
 			str=str+"	<td>"+cateVo.cateName+"</td>";
 			str=str+"	<td>"+cateVo.postCount+"</td>";
 			str=str+"	<td>"+cateVo.description+"</td>";
 			str=str+"	<td><img src='${pageContext.request.contextPath}/assets/images/delete.jpg' class= 'btnCateDel' data-no='"+cateVo.cateNo+"' ></td>";
 			str=str+"</tr>";
 			
 			if(updown == "up") {
 				$("#cate-area").prepend(str);
 			} else if(updown == "down"){
 				$("#cate-area").append(str);
 				
 			} else if(updown == "after"){
 				$("#cate-area-after").after(str);
 			}else {
 				console.log("오류");
 			}
 			
 		}; 
 		
 		 $("#add-cate-btn").on("click", function () {
 			var cateName = $("[name=name]").val();
 			var description =  $("[name=desc]").val();
 			
 			var cateVo = {
 					userNo : '${sessionScope.authUser.userNo}' ,
 					cateName : cateName ,
 					description : description
 			}
 			
 			console.log(cateVo);
 			$.ajax({
 				url : "${pageContext.request.contextPath }/api/addCate ",
 				type : "post",
 				contentType : "application/json",
 				data : JSON.stringify(cateVo),
 				dataType : "json",
 				success : function(cateVo){
 					console.log(cateVo);
 					render(cateVo,"after");
 					
 				},
 				error : function(XHR, status, error) {
 				console.error(status + " : " + error);
 				} 
 			});  	
 			$("[name=name]").val("");
 			$("[name=desc]").val("");
 			});
 		 
 		 $("#cate-area").on("click", ".btnCateDel", function(){
 			var cateNo =$(this).data("no") 
 		
 			 $.ajax({	//UserNo를 이용해서 카데고리 추가하기
 					url : "${pageContext.request.contextPath }/api/deletecate ",		  
 					type :"post",
 					data : {cateNo : cateNo},
 				
 					dataType : "json",
 					success : function(result){
 						if(result){
 							console.log("제거 완료");
 							$("#cate"+cateNo).remove();
 						} else {
 							console.log("제거 실패");
 						}
 					},
 					error : function(XHR, status, error) {
 						console.error(status + " : " + error);
 					}
 				}); 
 		}); 
</script>
</html>
