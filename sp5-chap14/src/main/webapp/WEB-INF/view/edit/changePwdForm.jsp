<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="change.pwd.title"/></title>
</head>
<body>
	<form:form>
	<p>
		<label><spring:message code="currentPassword" />
		<form:input path="currentPassword" />
		<form:errors path="currentPassword" />
		</label>
	</p>
	<p>
		<label><spring:message code="newPassword" />
		<form:password path="newPassword" />
		<form:errors path="newPassword" />
		</label>
	</p>
	<input type="submit" value="<spring:message code="change.btn" />">
	</form:form>
</body>
</html>