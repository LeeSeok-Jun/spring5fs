<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
</head>
<body>
	<h2>��������</h2>
	<form method="post">
	<!-- 
	<p> 1. ����� ������? <br/>
	<label><input type="radio" name="responses[0]" value = "����">
	���� ������</label>
	<label><input type="radio" name="responses[0]" value = "����Ʈ">
	����Ʈ ������</label>
	<label><input type="radio" name="responses[0]" value = "Ǯ����">
	Ǯ���� ������</label>
	</p>
	<p> 2. ���� ����ϴ� ���ߵ�����? <br/>
	<label><input type="radio" name="responses[1]" value = "Eclipse">
	Eclipse</label>
	<label><input type="radio" name="responses[1]" value = "Intellij">
	Intellij</label>
	<label><input type="radio" name="responses[1]" value = "Sublime">
	Sublime</label>
	</p>
	<p> 3. �ϰ� ���� ��?<br/>
	<input type="text" name="responses[2]">
	</p> -->
	
	<c:forEach var = "q" items="${questions}" varStatus="status">
	<p>
		${status.index + 1}.${q.title}<br/>
		<c:if test="${q.choice}">
			<c:forEach var="option" items="${q.options}">
				<label><input type="radio" name="responses[%{status.index}]" value="${option}">${option}</label>
			</c:forEach>
		</c:if>
		<c:if test="${! q.choice}">
			<input type="text" name="responses[${status.index}]">
		</c:if>
	</p>
	</c:forEach>
	
	<p> ������ ��ġ<br/>
	<input type="text" name="res.location">
	</p>
	<p> ������ ����<br/>
	<input type="text" name="res.age">
	</p>
	<input type = "submit" value="����">
	</form>
	
</body>
</html>