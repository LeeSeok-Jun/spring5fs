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
	<p><strong>${registerRequest.name }��</strong>
		ȸ�� ������ �Ϸ��߽��ϴ�.</p>
	<p><a href="<c:url value='/main'/>"> [ù ȭ�� �̵�]</a></p> -->
	<p>
	<spring:message code="register.done" arguments="${register.name}" />
	</p>
	<p>
		<a href="<c:url value='/main'/>">
			[<spring:message code="go.main" />]
		</a>
</body>
</html>