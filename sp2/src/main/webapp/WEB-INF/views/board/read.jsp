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
				<input type="text" name="bno" class="form-control form-control-user"
					value='<c:out value="${vo.bno}"/>' readonly="readonly">
			</div>

			<div class="form-group">
				<input type="text" name="title"
					class="form-control form-control-user" placeholder="타이틀"
					value='<c:out value="${vo.title}"/>' readonly="readonly">
			</div>

			<div class="form-group">
				<input type="text" name="content"
					class="form-control form-control-user" placeholder="컨텐츠"
					value='<c:out value="${vo.content}"/>' readonly="readonly">
			</div>
			<div class="form-group">
				<input type="text" name="writer"
					class="form-control form-control-user" placeholder="롸이터"
					value='<c:out value="${vo.writer}"/>' readonly="readonly">
			</div>
			<div class="form-group">
				<input type="text" name="RegDate"
					class="form-control form-control-user"
					value='<c:out value="${vo.regdate}"/>' readonly="readonly">
			</div>

			<button class="btn btn-primary btn-user btn-block modBtn">Modify/Delete</button>

			<hr>


			<button class="btn btn-secondary btn-user btn-block listBtn">Go
				to List</button>
			<hr>
			<button
				class="btn btn-outline-success btn-user btn-block addReplyBtn">ADD
				Reply</button>


		</div>
		<div class="card shadow mb-4">
			<div class="card-body">
				<ul class="replyList list-group">
					<li class="list-group-item">AAAAAAAAAAAAAAAAAAAAA</li>
				</ul>
			</div>
		</div>

	</div>
	<!-- /DataTales Example -->
</div>
<!-- /.container-fluid -->

<form id="actionForm" action="/board/modify" method="get">
	<input type='hidden' name='bno' value='${cri.bno }'> <input
		type='hidden' name='page' value='${cri.page }'> <input
		type='hidden' name='amount' value='${cri.amount }'> <input
		type='hidden' name='type' value='${cri.type }'> <input
		type='hidden' name='keyword' value='${cri.keyword }'>
</form>

<!-- Logout Modal-->
<div class="modal fade" id="replyModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Reply</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<input type="text" class="form-control mbno" value="${vo.bno}"
					readonly="readonly"> <input type="text"
					class="form-control" name="reply" value="푸슝"> <input
					type="text" class="form-control" name="replyer" value="빠슝">
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<button class="btn btn-primary replyBtn">Add Reply</button>
				<button class="btn btn-info modifyBtn"> MODIFY Reply</button>
				<button class="btn btn-danger deleteBtn">DELETE Reply</button>
			</div>
		</div>
	</div>
</div>
<style>
.modal-footer .hide{
display:none;
}
</style>

<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>



	
	console.log(replyService);
		
	var flag = '${result}'; //서버에서 받아온 문자열을 문자열로 전달해줍시다
	var actionForm =$("#actionForm");
	var bno = ${vo.bno};
    var replyList=$(".replyList");
	
    showPage();
    
    replyList.on("click","li",function(e){
    	
    	var rno = $(this).attr("data-rno");
    	
    	replyService.getReply(rno,function(reply){
    		
    		$(".mbno").val(reply.rno);
    		$("input[name=reply]").val(reply.reply);
    		$("input[name=replyer]").val(reply.replyer);
    		$("#replyModal").modal('show');
    		
    		$(".modifyBtn").removeClass("hide");
    		$(".replyBtn").addClass("hide");
    		$(".deleteBtn").removeClass("hide");
    	
    		
    	})
    	
    	
    	
    })
    
	$(".addReplyBtn").on("click", function(e) {
		$("#replyModal").modal("show");
		
		$(".modifyBtn").addClass("hide");
		$(".replyBtn").removeClass("hide");
		$(".deleteBtn").addClass("hide");
		
	});
	
	$(".modBtn").on("click", function(e) {
		actionForm.submit();
	});

	$(".listBtn").on("click", function(e) {
		actionForm.find("input[name='bno']").remove();
		actionForm.attr("action","/board/list").submit();
	});
	$(".replyBtn").on("click", function (e) {

	        let obj = {
	            bno: $(".mbno").val(),
	            reply: $("input[name='reply']").val(),
	            replyer: $("input[name='replyer']").val(),
	        }

	        replyService.addReply(obj, function () {
	            alert("성공")
	            $("#replyModal").modal('hide')
	            showPage();
	        });
	   });

	   function  showPage() {

           replyList.html("")
           replyService.getList(bno, function(arr){
               var str = '';
               for (var i =0;i< arr.length;i++){
                   // var reply = arr[i]; //이게 옛날방식
                   //
                   // console.log(reply);
                   //구조 분해 할당 문법
                   var {rno,bno,reply,replyer,replyDate} = arr[i];
                   //백틱 (`) 문법!
                   var temp = "<li class='list-group-item' data-rno="+rno+">"+
                             "<div class='rno'>"+rno+"</div>"+
                             "<div class='reply'>"+reply+"</div>"+
                             "<div class='replyer'>"+replyer+"</div>"+
                            "</li>";
                   str += temp;

               }
               replyList.append(str);
           })

       }
	    
	    
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