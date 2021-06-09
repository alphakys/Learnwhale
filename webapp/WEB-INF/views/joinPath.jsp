<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a
		href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=4aaff7ffacda146806735614f9f809de&redirect_uri=http://localhost:8088/learnwhale/api/kakao/login">
		<button class="btn-join btn btn-primary btn-sm" style="width:200px; height: 100px; cursor: pointer;">카카오 간편가입</button>
	</a>
	
	<a
		href="${pageContext.request.contextPath }/api/kakao/link">
		<button class="btn-join btn btn-primary btn-sm" style="width:200px; height: 100px; cursor: pointer;">카카오 link</button>
	</a>
	
	
	<a href="${pageContext.request.contextPath }/user/joinForm">
		<button class="btn-join btn btn-primary btn-sm" style="width:200px; height: 100px; cursor: pointer;">사이트 회원가입</button>
	</a>
	
	
</body>
</html>