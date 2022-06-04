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

	<div class="container-fluid ml-auto mr-auto">

		<%-- <section class="test">
			<h1>TEST CADmedica LOREM IPSUM...</h1>
			<h2 class="text-danger">Ęąćśż...</h2>
			
			<p>${modelTest}</p>
			
			<c:forEach items="${healthcareAll}" var="healthcare">
				<div class="card company">
					<div class="card-header">
						<h5>${healthcare['class'].simpleName} ${healthcare.name}</h5>
					</div>
					<div class="card-body">
						<p>lorem ipsum...</p>
					</div>
					<div class="card-footer">
						<a href="#">DETAILS</a>
					</div>
				</div>
			</c:forEach>
		</section> --%>
		

		
		<div id="carouselExampleIndicators" class="carousel slide ml-auto mr-auto" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		  </ol>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-50 ml-auto mr-auto" src="/resources/img/homepagepic-01.jpg" alt="First slide">
		      <div class="carousel-caption d-none d-md-block">
		        <h5>First slide label</h5>
		        <p>Some representative placeholder content for the third slide.</p>
		      </div>
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-50 ml-auto mr-auto" src="/resources/img/homepagepic-02.jpg" alt="Second slide">
		      <div class="carousel-caption d-none d-md-block">
		        <h5>LOREM IPSUM</h5>
		        <p>lorem ipsum</p>
		      </div>
		    </div>
		  </div>
		  <a class="carousel-control-prev bg-secondary border-right" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next bg-secondary border-left" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only bg-warning">Next</span>
		  </a>
		</div>

	</div>

	<jsp:include page="footer.jsp"/>
	

</body>

</html>