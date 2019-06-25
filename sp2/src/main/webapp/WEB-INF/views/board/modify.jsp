
</html><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">Board Modify/Delete Page</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Register</h6>
		</div>
		<div class="card-body">
			<form id='form1' >
				<div class="form-group">
					<input type="text" name="bno"
						class="form-control form-control-user"
						value='<c:out value="${vo.bno}"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<input type="text" name="title"
						class="form-control form-control-user" placeholder="타이틀"
						value='<c:out value="${vo.title}"/>'>
				</div>

				<div class="form-group">
					<input type="text" name="content"
						class="form-control form-control-user" placeholder="컨텐츠"
						value='<c:out value="${vo.content}"/>'>
				</div>
				<div class="form-group">
					<input type="text" name="writer"
						class="form-control form-control-user" placeholder="롸이터"
						value='<c:out value="${vo.writer}"/>' readonly="readonly">
				</div>

			</form>
			<button class="btn btn-danger btn-user btn-block">Delete</button>
			<button class="btn btn-warning btn-user btn-block">Modify</button>

			<hr>


			<a href="/board/list" class="btn btn-secondary btn-user btn-block">
				Go to List </a>

		</div>


	</div>
	<!-- /DataTales Example -->
</div>
<!-- /.container-fluid -->

<script>
	$(".btn-danger").on("click",function(){
		console.log("delete button clicked");
		
		var formObj=$("#form1");
		formObj.attr("action","/board/remove").attr("method", "post").submit();
	});
	
	$(".btn-warning").on("click",function(){
		console.log("modify button clicked");
		
		var formObj=$("#form1");
		formObj.attr("action","/board/modify").attr("method", "post").submit();
	});
</script>
<%@include file="../includes/footer.jsp"%>




</body>
</html>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/board/register" method = "post">
<div>
	<label>Title</label>
	<input type="text" name="title" value ="한글제목">
</div>
<div>
	<label>Content</label>
	<input type="text" name="content" value ="한글내용">
</div>
<div>
	<label>Writer</label>
	<input type="text" name="writer" value ="한글저자">
</div>
<div>
<input type="reset">
<input type="submit">
<a href="/board/list">목록가기</a>
</div>

</form>

</body>
</html> -->