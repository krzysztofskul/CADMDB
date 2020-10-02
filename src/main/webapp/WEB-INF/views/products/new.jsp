<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 18.02.2020
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">

        <form:form method="post" modelAttribute="newProduct">

            <div class="card">

                <div class="card-header text-center font-weight-bold">
                    NEW PRODUCT FORM
                </div>

                <div class="card-body">

                    <form:hidden path="id"/>

                    <c:set var="disabled" value="false"/>
                    <c:if test="${newProduct.manufacturer ne null}">
                        <c:set var="disabled" value="true"/>
                        <form:hidden path="manufacturer.id"/>
                    </c:if>
                    <div class="form-group">
                        <label for="manufacturer">MANUFACTURER:</label>
                        <form:select path="manufacturer.id" id="manufacturer" cssClass="form-control" disabled="${disabled}">
                            <c:forEach items="${allManufacturers}" var="manufacturer">
                                <form:option value="${manufacturer.id}" label="${manufacturer.id} ${manufacturer.name}"/>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="form-group">
                        <label for="productCategory">PRODUCT CATEGORY:</label>
                        <form:select path="productCategory.id" id="productCategory" cssClass="form-control">
                            <c:forEach items="${allProductCategories}" var="productCategory">
                                <form:option value="${productCategory.id}" label="${productCategory.code} | ${productCategory.namePlural}"/>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="form-group">
                        <label for="modelName">MODEL NAME:</label>
                        <form:input path="modelName" id="modelName" cssClass="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="price">PRICE:</label>
                        <form:input path="price" id="price" cssClass="form-control"/>
                    </div>
                </div>

                <div class="card-footer">
                    <form:button type="submit" class="btn btn-success">SAVE</form:button>
                </div>

            </div>

        </form:form>

    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
