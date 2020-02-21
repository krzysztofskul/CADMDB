<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

                <div class="card-header">
                    ADDING PRODUCTS TO ROOM FORM
                </div>

                <div class="card-body">

                    <form:hidden path="id"/>

                    <form:hidden path="roomCategory.id"/>

                    <form:hidden path="number"/>

                    <form:hidden path="name"/>

                    <form:hidden path="department.id"/>

                    <form:hidden path="budget"/>

                <%--todo *1--%>
                    <%--<div class="form-group">
                        <label for="productList">PRODUCTS:</label>
                        <c:forEach items="${allProducts}" var="product">
                            <c:forEach items="${room.productList}" var="productInRoom">
                                <br>
                                <c:if test="${product.id eq productInRoom.id}">
                                    <form:checkbox
                                            path="productList"
                                            value="id"
                                            label="${product.manufacturer.name} ${product.modelName}"
                                            id="productList"
                                            checked="checked"
                                    />
                                </c:if>
                                <c:if test="${product.id ne productInRoom.id}">
                                    <form:checkbox
                                            path="productList"
                                            value="id"
                                            label="${product.manufacturer.name} ${product.modelName}"
                                            id="productList"
                                    />
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </div>--%>
                    <%--<div class="form-group">
                        <label for="productList">PRODUCTS:</label>
                        <br>
                        <form:checkboxes
                                items="${allProducts}"
                                path="productList"
                                id="productList"
                                itemLabel="modelName"
                                itemValue="id"
                        />
                    </div>
                    <form:select path="productList">
                        <form:options
                                items="${allProducts}"
                                itemValue="id"
                                itemLabel="modelName"
                        />
                    </form:select>
                    --%>
                    <form:checkboxes path="productList" items="${allProducts}"
                        itemLabel="modelName" itemValue="id"
                    />

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
