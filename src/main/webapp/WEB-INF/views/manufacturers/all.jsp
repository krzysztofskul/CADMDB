<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 15.02.2020
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <div class="card">
            <div class="card-header font-weight-bold text-center">
                ALL MANUFACTURERS LIST
            </div>

            <div class="card-body">
                <c:forEach items="${manufacturers}" var="manufacturer">
                    <div class="row bg-light font-weight-bold border-top border-bottom mt-3 mb-1">
                        <div class="col-12">
                            ${manufacturer.name}
                        </div>
                    </div>

                    <c:forEach items="${productCategories}" var="productCategory">

                        <div class="row bg-light mt-1 mb-1">
                            <div class="col-12 font-weight-bold text-black-50">
                                    ${productCategory.name}
                            </div>
                        </div>

                        <c:forEach items="${manufacturer.productList}" var="product">

                            <c:if test="${productCategory.id eq product.productCategory.id}">

                                <div class="row">
                                    <div class="col-3">
                                            ${product.modelName}
                                    </div>
                                    <div class="col-3">
                                        <fmt:formatNumber
                                                type="currency"
                                                currencySymbol="zł"
                                                value="${product.price}"
                                                minFractionDigits="2"
                                                maxFractionDigits="2"
                                        />
                                    </div>
                                    <div class="col-3">
                                    </div>
                                    <div class="col-3">
                                        <a href="#">DETAILS/EDIT</a>
                                        <a href="/manufacturers/productAddToRoom?productId=${product.id}" class="text-success">ADD TO ROOM</a>
                                        <a href="#" class="text-danger">DEL</a>
                                    </div>
                                </div>
                            </c:if>


                        </c:forEach>

                    </c:forEach>


                    <div class="row mt-2">
                        <div class="col-12">
                            <a href="/products/new?manufacturerId=${manufacturer.id}" class="btn btn-success float-right">NEW PRODUCT</a>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="card-footer">
                <a href="/manufacturers/new" class="btn btn-success float-right">NEW MANUFACTURER</a>
            </div>

        </div>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
