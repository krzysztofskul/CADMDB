<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 30.05.2020
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="room" action="/rooms/changeProduct">
            <form:hidden path="id"/>
            <form:hidden path="name"/>
            <form:hidden path="budget"/>
            <form:hidden path="number"/>
            <form:hidden path="fullPath"/>
            <form:hidden path="area"/>
            <form:hidden path="height"/>
            <form:hidden path="department.id"/>
            <form:hidden path="roomCategory.id"/>
            <input type="hidden" name="productToDelId" value="${productToDelId}">
<%--            <form:hidden path="productList"/>--%>
            <div class="card">
                <div class="card-header">
                    CHOOSE NEW PRODUCT
                </div>
                <div class="card-body">
                    <div class="input-group mb-3">
                        <select class="custom-select" type="text" name="productNewId">
                            <c:forEach items="${productList}" var="product">
                                <option value="${product.id}">
                                        ${product.manufacturer.name}
                                        ${product.modelName}
                                        <fmt:formatNumber
                                                type="currency"
                                                minIntegerDigits="1"
                                                maxIntegerDigits="12"
                                                minFractionDigits="2"
                                                maxFractionDigits="2"
                                                value="${product.price}"
                                                currencySymbol="zł"
                                        />
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="card-footer">
                    <button class="btn btn-success float-right" type="submit">SAVE</button>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="../footer.jsp"/>


</body>
</html>
