<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����</title>
</head>
<body>
	<p>���� ���� : </p>
	<ul>
		<c:forEach var="responses"
			items="${ansData.responses}" varStatus="status">
		<li>${status.index + 1}�� ���� : ${responses}</li>
		</c:forEach>
	</ul>
	<p>������ ��ġ : ${ansData.res.location}</p>
	<p>������ ���� : ${ansData.res.age}</p>
</body>
</html>