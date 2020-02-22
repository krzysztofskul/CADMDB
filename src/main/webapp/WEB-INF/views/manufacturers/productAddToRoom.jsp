<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysztofskul
  Date: 22.02.2020
  Time: 00:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <jsp:include page="../header.jsp"/>

    <div class="container">
        <form:form method="post" modelAttribute="productToAdd">
            <div class="card">

                <div class="card-header text-center font-weight-bold">
                    PRODUCT ADD TO ROOM FORM
                </div>

                <div class="card-body">

                    <form:hidden path="id"/>

                    <form:hidden path="modelName"/>

                    <form:hidden path="manufacturer.id"/>

                    <c:forEach items="${allRooms}" var="room">
                        <input type="checkbox"
                               name="rooms"
                               value="${room.id}"
                               class="d-inline-block"
                        />${room.fullPath}<br>
                    </c:forEach>

                    <form:hidden path="price"/>

                    <form:hidden path="productCategory.id"/>

                </div>

                <div class="card-footer">
                    <form:button
                            class="btn btn-success float-right"
                            type="submit"
                    >
                        SAVE
                    </form:button>
                </div>

            </div>
        </form:form>
    </div>

    <jsp:include page="../footer.jsp"/>

</body>
</html>
