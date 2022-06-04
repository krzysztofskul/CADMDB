<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
</head>

<body>

	<jsp:include page="header.jsp"/>

	<section class="test">
		<h1>TEST CADmedica LOREM IPSUM...</h1>
		<h2 class="text-danger">Ęąćśż...</h2>
		
		<p>${modelTest}</p>
		
		<c:forEach items="${healthcareAll}" var="healthcare">
			<h1>healthcare id: ${healthcare.name}</h1>
		</c:forEach>
	</section>
	
	<jsp:include page="footer.jsp"/>
	

</body>

</html>