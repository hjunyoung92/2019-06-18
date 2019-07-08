<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Upload Ajax Page</h1>


<div id = "bigpicture"></div>

<div>
<input type='file' name='uploadFile' multiple>

</div>
<button id='uploadBtn'>Upload</button>
<ul id="uploadResult">

</ul>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
  
 <script>
 $(document).ready(function () {
	 var uploadResult = $("#uploadResult");
	 
	 
	$('#uploadBtn').click(function(e){
	var inputFile = $("input[name='uploadFile']")
	
	
	
	uploadResult.on("click","img",function(e){
			var originName = $(this).attr("data-origin")
	})
	
	var formData = new FormData();
	
	var files = inputFile[0].files;
	
	for (var i = 0; i < files.length; i++) {
		formData.append("uploadFile", files[i]);
		
	}
	
	
	$.ajax({
		url:'/uploadAjaxAction',
		processData:false,
		contentType:false,
		data:formData,
		dataType:'json',
		type:'post',
		success:function(result){
			alert("upload***")
			
			console.log(result)
			
			
			
			for (var i = 0; i < result.length; i++) {
				var originName = result[i].uuid+"_"+result[i].fileName;
				var thumbName = "s_"+result[i].uuid+"_"+result[i].fileName;
				
				uploadResult.append("<li><img data-origin ='"+originName+"' src='/viewImage?file="+thumbName+"'></li>");
			}//end for
			
			
		}//end success
		
	});//ajax end
	
	});// id uploadBtn end
});
 </script>
</body>
</html>