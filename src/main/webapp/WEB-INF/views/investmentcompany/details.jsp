<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>

	<jsp:include page="../header.jsp"/>
	
	<div class="container-fluid">
	
		<section class="test">
			<p>${investmentCompany.id}</p>
			<p>${investmentCompany.name}</p>
		</section>
	
	</div>
	
	<jsp:include page="../footer.jsp"/>

</body>
</html>