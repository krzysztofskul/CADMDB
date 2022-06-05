<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../header.jsp"/>

	<div class="container-fluid main-content">
	
		<c:forEach items="${investmentCompanyAll}" var="investmentCompany">
			<div class="card company">
				<div class="card-header">
					<h5>${investmentCompany.name}</h5>
				</div>
				<div class="card-body">
					<p>${investmentCompany.country}</p>
					<p>${investmentCompany.postalCode} ${investmentCompany.city}</p>
					<p>${investmentCompany.street}, ${investmentCompany.streetNo}</p>
				</div>
				<div class="card-footer">
					<a href="/investment-company/details/${investmentCompany.id}">DETAILS</a>
				</div>
			</div>
		</c:forEach>
	
	</div>
	
	<jsp:include page="../footer.jsp"/>

</body>
</html>