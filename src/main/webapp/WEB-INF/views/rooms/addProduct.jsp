<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 19.02.2020
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="room">

            <div class="card">

                <div class="card-header text-center">
                    ADDING PRODUCTS TO ROOM FORM
                </div>

                <div class="card-body">

                    <form:hidden path="id"/>

                    <form:hidden path="roomCategory.id"/>

                    <form:hidden path="number"/>

                    <form:hidden path="name"/>

                    <form:hidden path="department.id"/>

                    <form:hidden path="budget"/>

                    <c:forEach items="${productCategoryList}" var="productCategory">
                        <div class="row mb-1 border bg-light h6 p-1 m-1">
                            <div class="col-sm-2">
                                ${productCategory.code}
                            </div>
                            <div class="col-sm-10">
                                ${productCategory.name}
                            </div>
                        </div>
                        <c:forEach items="${allProducts}" var="productToAdd">
                            <c:if test="${productCategory.code eq productToAdd.productCategory.code}">

                                <div class="row
                                    input-group-text  m-1 p-1 border-0 bg-light"
                                >
                                    <div class="col-sm-1">
                                        <input type="checkbox"
                                               name="productToAdd"
                                               value="${productToAdd.id}"
<%--                                               aria-label="Checkbox for following text input"--%>
                                        >
                                    </div>
                                    <div class="col-sm-9 m-0 p-0 bg-light text-left">
                                        ${productToAdd.manufacturer.name} ${productToAdd.modelName}
                                    </div>
                                    <div class="col-sm-2 text-right">
                                        <fmt:formatNumber
                                            type="currency"
                                            minIntegerDigits="1"
                                            maxIntegerDigits="12"
                                            minFractionDigits="2"
                                            maxFractionDigits="2"
                                            currencySymbol="zł"
                                            value="${productToAdd.price}"
                                        />
                                    </div>
                                </div>

                            </c:if>
                        </c:forEach>
                    </c:forEach>

                </div>

                <div class="card-footer">
                    <form:button type="submit" class="btn btn-success float-right">
                        SAVE
                    </form:button>
                </div>

            </div>

        </form:form>
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
