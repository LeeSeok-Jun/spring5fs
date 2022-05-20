<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="memeber.register" /></title>
</head>
<body>
<!-- 
	<p><strong>${registerRequest.name }님</strong>
		회원 가입을 완료했습니다.</p>
	<p><a href="<c:url value='/main'/>"> [첫 화면 이동]</a></p> -->
	<p>
	<spring:message code="register.done" arguments="${register.name}" />
	</p>
	<p>
		<a href="<c:url value='/main'/>">
			[<spring:message code="go.main" />]
		</a>
</body>
</html>