<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code ="login.title" /></title>
</head>
<body>
	<form:form modelAttribute="loginCommand" >
	<form:errors/>
	<p>
		<label><spring:message code="email" />
		<form:input path="email" />
		<form:errors path="email" />
		</label>
	</p>
	<p>
		<label><spring:message code="password" />
		<form:password path="password" />
		<form:errors path="password" />
		</label>
	</p>
	<p>
		<label><spring:message code="rememberEmail"/>
		<form:checkbox path="rememberEmail" />
		</label>
	</p>
	<input type="submit" value="<spring:message code="login.btn" />" >
	</form:form>
</body>
</html>