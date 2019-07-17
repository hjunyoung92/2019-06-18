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
	<h1>ADMIN</h1>
	<h2><sec:authentication property="principal.vo.username"/></h2>
	<hr/>
	<h2><sec:authentication property="principal.username"/></h2>
	<hr/>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	ADMIN ONLY</sec:authorize>
</body>
</html>