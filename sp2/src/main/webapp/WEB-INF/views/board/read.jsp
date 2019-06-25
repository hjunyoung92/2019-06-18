<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">Board Read Page</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Register</h6>
		</div>
		<div class="card-body">
			<div class="form-group">
				<input type="text" name="bno"
					class="form-control form-control-user"  value='<c:out value="${vo.bno}"/>' 
					readonly="readonly">
			</div>

			<div class="form-group">
				<input type="text" name="title"
					class="form-control form-control-user" placeholder="타이틀" value='<c:out value="${vo.title}"/>' 
					readonly="readonly">
			</div>

			<div class="form-group">
				<input type="text" name="content"
					class="form-control form-control-user" placeholder="컨텐츠" value='<c:out value="${vo.content}"/>' 
					readonly="readonly">
			</div>
			<div class="form-group">
				<input type="text" name="writer"
					class="form-control form-control-user" placeholder="롸이터" value='<c:out value="${vo.writer}"/>' 
					readonly="readonly">
			</div>
			<div class="form-group">
				<input type="text" name="RegDate"
					class="form-control form-control-user"  value='<c:out value="${vo.regdate}"/>' 
					readonly="readonly">
			</div>
			
			<a href="/board/modify?bno=${vo.bno}"><button class="btn btn-primary btn-user btn-block">Modify/Delete</button></a>

			<hr>


			<a href="/board/list" class="btn btn-secondary btn-user btn-block">
				Go to List </a>

		</div>


	</div>
	<!-- /DataTales Example -->
</div>
<!-- /.container-fluid -->

<script>
		var flag = '${result}'; //서버에서 받아온 문자열을 문자열로 전달해줍시다

		if (flag === 'success') {
			alert("작업이 성공했습니다");
		}
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