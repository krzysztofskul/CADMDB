<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="co" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 24.02.2020
  Time: 17:38
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
                ALL PRODUCTS SORTED BY PRODUCT CATEGORY CODE
            </div>

            <div class="card-body">
                <c:forEach items="${allProductCategories}" var="productCategory">
                    <div>
                        <div class="row bg-light font-weight-bold border-top border-bottom mt-1 mb-1">
                            <div class="col-2">
                                ${productCategory.code}
                            </div>
                            <div class="col-10">
                                ${productCategory.namePlural}
                            </div>
                        </div>
                    </div>
                    <c:forEach items="${productCategory.productList}" var="product">
                        <div class="row">
                            <div class="col-6">
                                    <span class="font-weight-bold">${product.manufacturer.name}</span>
                                    ${product.modelName}
                            </div>
                            <div class="col-2">
                                <fmt:formatNumber
                                        type="currency"
                                        minFractionDigits="2"
                                        maxFractionDigits="2"
                                        currencySymbol="zł"
                                        value="${product.price}"
                                />
                            </div>
                            <div class="col-3">
                                <a href="/products/${product.id}">DETAILS</a>
                                <a href="/manufacturers/productAddToRoom?productId=${product.id}" class="text-success">ADD TO ROOM</a>
                                <a href="#" class="text-danger">DEL</a>
                            </div>
                        </div>
                    </c:forEach>
                </c:forEach>
            </div>

            <div class="card-footer">

            </div>

        </div>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
