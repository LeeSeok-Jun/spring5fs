<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보</title>
</head>
<body>
	<p>아이디 : ${member.id }</p>
	<p>이메일 : ${member.email }</p>
	<p>이름 : ${member.name }</p>
	<p>가입일 : <tf:formatDateTime value="${member.registerDateTime }" pattern="yyyy-MM-dd HH:mm" /></p>
</body>
</html>