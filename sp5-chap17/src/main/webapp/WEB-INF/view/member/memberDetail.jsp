<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
</head>
<body>
	<p>���̵� : ${member.id }</p>
	<p>�̸��� : ${member.email }</p>
	<p>�̸� : ${member.name }</p>
	<p>������ : <tf:formatDateTime value="${member.registerDateTime }" pattern="yyyy-MM-dd HH:mm" /></p>
</body>
</html>