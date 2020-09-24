<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 24.09.2020
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CADMDB</title>
</head>
<body>

    <div class="container">

        <jsp:include page="../header.jsp"/>

        <div class="content">

            <div class="card">
                <%-- HEADER: MANUFACTURER'S DETAILS/INFO --%>
                <div class="card-header">
                    <div class="row h-50">
                        <div class="col-9">
                            <h4>${manufacturer.name} ${manufacturer.companyType}</h4>
                            <h6>${manufacturer.country} ${manufacturer.postalCode} ${manufacturer.city}</h6>
                            <h6>${manufacturer.streetName} ${manufacturer.streetNumber}</h6>
                            <h6>${manufacturer.phoneNumber}</h6>
                            <h6>${manufacturer.email}</h6>
                            <h6>${manufacturer.website}</h6>
                        </div>
                        <div class="col-3">
                            <img src="/resources/img/logosIpsum/logo-10.svg" alt="logo" height="50px" class="float-right"/>
                        </div>
                    </div>
                </div>
                <%-- BODY: MANUFACTURER'S PRODUCT CATEGORIES / PRODUCTS --%>
                <div class="card-body">
                    <c:forEach items="${productCategoryList}" var="productCategory">
                        <div class="row mb-1 bg-light border-top border-bottom">
                            <div class="col-2">
                                <h5>${productCategory.code}</h5>
                            </div>
                            <div class="col-8">
                                <h5>${productCategory.name}</h5>
                            </div>
                            <div class="col-2">
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <%-- FOOTER --%>
                <div class="card-footer"></div>
            </div>

        </div>

        <jsp:include page="../footer.jsp"/>

    </div>

</body>
</html>
