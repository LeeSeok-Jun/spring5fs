<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
</head>
<body>
	<h2>ȸ�� ���� �Է�</h2>
	<!-- <form action="step3" method="post"> -->
	<form:form action="step3" modelAttribute="registerRequest">
	<p>
		<label>�̸��� : <br>
		<!--  <input type ="text" name = "email" id ="email"> -->
		<form:input path="email"/>
		</label>
	</p>
	<p>
		<label>�̸� : <br>
		<!-- <input type ="text" name = "name" id ="name"> -->
		<form:input path="name"/>
		</label>
	</p>
	<p>
		<label>��й�ȣ : <br>
		<!-- <input type ="password" name = "password" id ="password"> -->
		<form:password path="password"/>
		</label>
	</p>
	<p>
		<label>��й�ȣ Ȯ�� : <br>
		<!-- <input type ="password" name = "confirmPassword" id ="confirmPassword"> -->
		<form:password path="confirmPassword"/>
		</label>
	</p>
	<input type="submit" value="���� �Ϸ�">
	<!-- </form> -->
	</form:form>
</body>
</html>