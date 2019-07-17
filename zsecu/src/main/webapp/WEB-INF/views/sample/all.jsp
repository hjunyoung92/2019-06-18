<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ALLLLLLLLLL</h1>
	
	<sec:authorize access="isAnonymous()"> Would you DO login plz? </sec:authorize>
	<sec:authorize access="isAuthenticated()"> Would you DO LogOut plz? </sec:authorize>
</body>
</html>